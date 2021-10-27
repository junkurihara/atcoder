atcoder_contest = {"ABC", "ARC", "AGC", "AHC"}

if __name__ == "__main__":
  input_set = set()
  for _ in range(3):
    input_set.add(input())
  subset = atcoder_contest.difference(input_set)
  print(subset.pop())
