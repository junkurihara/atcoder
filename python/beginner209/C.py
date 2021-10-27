MOD = 10**9 + 7

if __name__ == "__main__":
  _n = int(input())
  _cs = sorted(list(map(int, input().split())))

  coef = 1
  for idx, c in enumerate(_cs):
    if c - idx < 1:
      print(0)
      quit()
    else:
      coef = coef * (c-idx) % MOD

  print(coef)
