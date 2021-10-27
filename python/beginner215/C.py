from itertools import permutations

if __name__ == "__main__":
  _s,_k = input().split()
  int_k = int(_k)
  list_s = list(_s)

  permutated = set(permutations(list_s))
  sorted_words = sorted([list(w) for w in permutated])
  print("".join(sorted_words[int_k-1]))
