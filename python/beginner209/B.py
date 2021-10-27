from functools import reduce

if __name__ == "__main__":
  _n, _x = map(int, input().split())
  _as = list(map(int, input().split()))

  total = 0
  for idx, p in enumerate(_as):
    total += p - (idx % 2)

  if total <= _x:
    print("Yes")
  else:
    print("No")
