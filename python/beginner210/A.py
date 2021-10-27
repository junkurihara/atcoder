
if __name__ == "__main__":
  _n, _a, _x, _y = map(int, input().split())
  print(_x * min(_a, _n) + _y * max(0, _n - _a))
