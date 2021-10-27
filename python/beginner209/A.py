if __name__ == "__main__":
  _a, _b = map(int, input().split())
  print(max(
    _b - _a + 1, 0
  ))
