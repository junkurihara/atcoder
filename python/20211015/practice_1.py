def practice_1(a, bc, s):
  bc_split = list(map(int, bc.split()))
  assert(len(bc_split) == 2)
  print("%s %s" % (a+bc_split[0]+bc_split[1], s))

if __name__=="__main__":
  _a = int(input())
  _bc = input()
  _s = input()
  practice_1(_a, _bc, _s)
