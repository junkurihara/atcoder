candidates_list = ['dream', 'dreamer', 'erase', 'eraser']

def check(strseq, candidates_list):
  ptr = len(strseq)

  while ptr > 0 :
    hit_candidate = None
    for candidate in candidates_list:
      substr = strseq[ptr - len(candidate) : ptr]
      if substr == candidate:
        hit_candidate = candidate
        break
    if hit_candidate is None:
      print("NO")
      return
    else:
      ptr = ptr - len(hit_candidate)

  if ptr == 0:
    print("YES")
  else:
    print("NO")


if __name__ == "__main__":
  s = input()
  check(s, candidates_list)
