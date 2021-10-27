if __name__ == "__main__":
  _x = list(input())
  _x_dict = {v: idx for idx, v in enumerate(_x)}
  _n = int(input())
  _ss = []
  for i in range(_n):
    _ss.append(input())

  numbered = []
  for _s in _ss:
    _s = list(_s)
    mapped_s = [_x_dict[key] for key in _s]
    numbered.append(mapped_s)
  num_sorted = sorted(numbered)

  numbered_dict = {str(key): idx for idx, key in enumerate(numbered)}

  for key in num_sorted:
    print(_ss[numbered_dict[str(key)]])
