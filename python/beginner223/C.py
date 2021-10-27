from functools import reduce


class Doukasen:
  def __init__(self, ai, bi):
    self.length = ai
    self.speed = bi
    self.ttl = ai/bi

if __name__ == "__main__":
  _n = int(input())
  doukasens = []
  for i in range(_n):
    ai, bi = map(int, input().split())
    elem = Doukasen(ai, bi)
    doukasens.append(elem)

  matched_time = reduce(lambda accum, i: accum + i.ttl, doukasens, 0)/2

  accum_ttl = 0
  accum_len = 0
  matched_idx = 0
  for idx, dksn in enumerate(doukasens):
    if accum_ttl+dksn.ttl > matched_time:
      matched_idx = idx
      break
    else:
      accum_ttl += dksn.ttl
      accum_len += dksn.length

  remained_time = matched_time - accum_ttl
  remained_len = accum_len + doukasens[matched_idx].speed * remained_time

  print(remained_len)
