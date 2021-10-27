if __name__ == "__main__":
  _x = int(input())
  if _x >= 90:
    print("expert")
  elif _x >= 70:
    print(90-_x)
  elif _x >= 40:
    print(70-_x)
  else:
    print(40-_x)
