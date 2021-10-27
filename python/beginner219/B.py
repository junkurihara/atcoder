if __name__ == "__main__":
  _s123 = []
  for _ in range(3):
    _s123.append(input())

  _t = list(map(int, list(input())))

  print(
    "".join([_s123[key-1] for key in _t])
  )
