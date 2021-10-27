if __name__ == "__main__":
  _s, _t = map(int, input().split())

  matched = 0
  for a in range(_s+1):
    remained_a = _s - a
    for b in range(remained_a+1):
      remained_b = remained_a - b
      for c in range(remained_b+1):
        if a * b * c <= _t:
          matched += 1

  print(matched)
