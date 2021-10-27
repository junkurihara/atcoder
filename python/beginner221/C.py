from itertools import combinations
from functools import reduce

def list_to_int(listed_int):
  ord = len(listed_int)
  rev = list(reversed(listed_int))
  num = reduce(lambda accum, i: accum + rev[i]*(10**i), range(ord), 0)
  return num

def divide_list_idx(list_len, sep_len):
  idx_comb = list(combinations(range(list_len), sep_len))
  divided = []
  for p in idx_comb:
    remained = []
    for c in range(list_len):
      if not {c}.issubset(set(p)):
        remained.append(c)

    divided.append( (p, remained) )
  return divided


def calc(_n_list):
  max = 0
  for comb_len in range(1, int(len(_n_list)/2)+1):
    idx_divided = divide_list_idx(len(_n_list), comb_len)
    for idxes in idx_divided:
      num1_list_sorted = sorted([_n_list[i] for i in idxes[0]], reverse=True)
      num2_list_sorted = sorted([_n_list[i] for i in idxes[1]], reverse=True)
      num1 = list_to_int(num1_list_sorted)
      num2 = list_to_int(num2_list_sorted)
      prod = num1 * num2
      if prod > max:
        max = prod
  return max


if __name__ == '__main__':
  _n = str(input())
  _n_list = list(map(int, list(_n)))

  max = calc(_n_list)
  print(max)
