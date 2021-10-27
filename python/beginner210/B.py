if __name__ == "__main__":
  _n = int(input())
  _s = input()
  str_len = len(_s)
  int_len = len(bin(int(_s, 2))[2:])
  diff = str_len - int_len

  if diff % 2 == 0:
    print("Takahashi")
  else:
    print("Aoki")
