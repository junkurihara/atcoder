

if __name__ == "__main__":
  _n, _m = map(int, input().split())
  _as = sorted(set(map(int, input().split())))
  _bs = sorted(set(map(int, input().split())))


  minim = 10 ** 9
  ptr_b = 0
  for a in _as:
    if a >= _bs[ptr_b]:
      while a >= _bs[ptr_b] and ptr_b < len(_bs) - 1:
        ptr_b += 1
    else:
      while a <= _bs[ptr_b] and ptr_b > 0:
        ptr_b -= 1

    diff = abs(a-_bs[ptr_b])
    diff_2 = abs(a-_bs[ptr_b+1]) if ptr_b < len(_bs) - 1 else diff
    diff_3 = abs(a-_bs[ptr_b-1]) if ptr_b > 0 else diff
    if min(diff, diff_2, diff_3) < minim:
      minim = min(diff, diff_2, diff_3)

  print(minim)
