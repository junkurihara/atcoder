from functools import reduce

def calc(seq, x):
  seq_total = reduce(lambda accum, elem: accum+elem, seq, 0)

  re = x % seq_total
  steps = int((x-re)/seq_total)

  addition = 0
  for cnt, a in enumerate(seq):
    addition += a
    if addition > re:
      print(steps*len(seq)+cnt+1)
      return

if __name__ == '__main__':
  _n = int(input())
  _as = list(map(int, input().split()))
  assert(_n == len(_as))
  _x = int(input())
  calc(_as, _x)
