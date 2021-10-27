from functools import reduce

if __name__ == "__main__":
  _s123 = list(map(int, list(input())))
  assert(len(_s123) == 3)
  assert(all([ key == 0 or key == 1 for key in _s123 ]))
  cnt = reduce(
    lambda accum, i: accum + i,
    _s123,
    0
  )
  print(cnt)
