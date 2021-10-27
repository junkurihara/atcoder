divide = 998244353

class Diff:
  def __init__(self, ai, bi):
    self.base = ai
    self.margin = bi - ai

def count_possible(base, diff_list):
  if diff_list[0].base+diff_list[0].margin == base:
    return 1

  if len(diff_list) == 1:
    # print(diff_list[0].margin, diff_list[0].base, base)
    new_base = diff_list[0].base - base
    return diff_list[0].margin - new_base
  else:
    cnt = 0
    for p in range(diff_list[0].margin + 1):
      cnt += count_possible(diff_list[0].base + p, diff_list[1:])
    return cnt


if __name__ == "__main__":
  _n = int(input())
  _a = list(map(int, input().split()))
  _b = list(map(int, input().split()))

  diff_list = []
  for ai, bi in zip(_a, _b):
    diff_list.append(Diff(ai, bi))

  cnt = count_possible(0, diff_list)
  print(cnt)
