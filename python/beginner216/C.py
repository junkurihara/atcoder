MAX_TRIAL = 120

if __name__ == "__main__":
  _n = int(input())

  rev_ball_num = _n
  rev_magic = ""
  for trial in range(MAX_TRIAL):
    if rev_ball_num == 0:
      break

    if rev_ball_num % 2 == 1:
      rev_ball_num -= 1
      rev_magic = rev_magic + "A"
    else:
      rev_ball_num = rev_ball_num//2
      rev_magic = rev_magic + "B"

  magic = "".join(list(reversed(rev_magic)))
  print(magic)
