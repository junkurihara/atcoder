DIV = 10 ** 9 + 7

if __name__ == "__main__":
  # _s = "chokudaichokudaichokudai"
  _s = input()
  chokudai = list("chokudai")

  dp = [[ [] for _ in range(len(chokudai)+1) ] for _ in range(len(_s)+1) ]

  for s_idx in range(len(_s) + 1):
    for c_idx in range(len(chokudai) + 1):
      if c_idx == 0:
        dp[s_idx][c_idx] = 1
      elif s_idx == 0:
        dp[s_idx][c_idx] = 0
      elif _s[s_idx - 1] == chokudai[c_idx - 1]:
        dp[s_idx][c_idx] = (dp[s_idx - 1][c_idx - 1] + dp[s_idx - 1][c_idx]) % DIV
      else:
        dp[s_idx][c_idx] = dp[s_idx - 1][c_idx]

  print(dp[len(_s)][len(chokudai)])
