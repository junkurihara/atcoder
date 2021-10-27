if __name__ == '__main__':
  _a, _b, _c = map(int, input().split())
  if _b - (_b % _c) < _a:
    print(-1)
  else:
    print(_c * int(_b/_c))
