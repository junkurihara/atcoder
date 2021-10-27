def calc(s, t):
  offset = 1
  for ptr in range(len(s)-1):
    s_window = s[:ptr] + s[ptr+offset+1:]
    s_mid = s[ptr:ptr+offset+1]
    t_window = t[:ptr] + t[ptr+offset+1:]
    t_mid = t[ptr:ptr+offset+1]
    if s_window == t_window:
      if s_mid == t_mid:
        print('Yes')
        return
      elif s_mid[0] == t_mid[1] and s_mid[1] == t_mid[0]:
        print('Yes')
        return

  print('No')


if __name__ == "__main__":
  s = input()
  t = input()
  assert(len(s) == len(t) and len(s) > 1 and len(t) >1 and len(s) <=100 and len(t) <=100)
  calc(s,t)
