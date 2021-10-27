if __name__ == "__main__":
  _n = int(input())
  _as = list(map(int, input().split()))

  dict_as = {v: idx+1 for idx, v in enumerate(_as)}
  m = max(_as)
  del dict_as[m]
  m2 = max(dict_as.keys())
  print(dict_as.get(m2))
