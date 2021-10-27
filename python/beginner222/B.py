from functools import reduce

if __name__ == "__main__":
  _np = list(map(int, input().split()))
  _n = _np[0]
  _p = _np[1]

  _as = list(map(int, input().split()))
  cnt = reduce(lambda accum, _a: accum + 1 if _a < _p else accum, _as, 0)
  print(cnt)
