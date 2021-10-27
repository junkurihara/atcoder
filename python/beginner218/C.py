from functools import reduce

class Rect:
  def __init__(self, org):
    self.org = org
    self.ext = None
    self.extract()

  def extract(self):
    len_n = len(self.org)
    col_min = -1
    col_max = 0
    for col_idx in range(len_n):
      col = { row[col_idx]: True for row in self.org }
      if col.get("#") is not None:
        col_max = col_idx
        if col_min == -1:
          col_min = col_idx

    row_min = -1
    row_max = 0
    for row_idx, row in enumerate(self.org):
      if "#" in row:
        row_max = row_idx
        if row_min == -1:
          row_min = row_idx

    self.ext = []
    for y in self.org[row_min:row_max+1]:
      self.ext.append(y[col_min:col_max+1])

  def stringified(self, array):
    # standard
    return "".join(reduce(lambda acc, elem: acc + elem, array, []))

  def rotate90(self, array):
    rot90 = list()
    for col_idx in range(len(array[0])):
      rot90.append(
        [row[len(row) - col_idx - 1] for row in array]
      )
    return rot90



  def rotated_stringified(self):
    # standard
    stringified = set()
    stringified.add(self.stringified(self.ext))

    # 90
    ext90 = self.rotate90(self.ext)
    stringified.add(self.stringified(ext90))

    #180
    ext180 = self.rotate90(ext90)
    stringified.add(self.stringified(ext180))

    #270
    ext270  = self.rotate90(ext180)
    stringified.add(self.stringified(ext270))

    return stringified



if __name__ == "__main__":
  _n = int(input())

  _s = []
  for i in range(_n):
    _s.append(list(input()))

  _t = []
  for i in range(_n):
    _t.append(list(input()))

  rect_s = Rect(_s)
  rect_t = Rect(_t)
  set_str_t = rect_t.rotated_stringified()
  str_s = rect_s.stringified(rect_s.ext)
  if {str_s}.issubset(set_str_t):
    print("Yes")
  else:
    print("No")
