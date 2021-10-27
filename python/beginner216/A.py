if __name__ == "__main__":
  _x, _y = map(int, input().split("."))
  if _y <= 2:
    print("{}-".format(_x))
  elif _y <= 6:
    print(_x)
  else:
    print("{}+".format(_x))
