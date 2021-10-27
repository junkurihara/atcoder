from functools import reduce

def calc(num_list):
  num_list.sort(reverse=True)
  a_score = reduce(lambda accum, x: accum + num_list[x] if x % 2 == 0 else accum, range(len(num_list)), 0)
  b_score = reduce(lambda accum, x: accum + num_list[x] if x % 2 == 1 else accum, range(len(num_list)), 0)
  print(a_score - b_score)

if __name__ == '__main__':
  _n = int(input())
  assert(_n > 0 and _n <= 100)
  _as = list(map(int, input().split()))
  assert(len(_as) == _n)
  assert(all([i > 0 and i <= 100 for i in _as]))
  calc(_as)
