if __name__ == "__main__":
  _ab = list(map(int, input().split()))
  assert(len(_ab) == 2)
  _a = _ab[0]
  _b = _ab[1]
  assert(_a <= 9 and _b <= _a and _b >= 3)
  print(32 ** (_a - _b))
