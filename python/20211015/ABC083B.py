from functools import reduce

def sum_of_log_exp(num):
  nums = list(map(int, list(str(num))))
  sum = reduce(lambda accum, elem: accum + elem, nums, 0)
  return sum

def calc(num_list, min, max):
  accum = 0
  for elem in num_list:
    sle = sum_of_log_exp(elem)
    if sle >= min and sle <= max:
      accum += elem

  print(accum)


if __name__ == '__main__':
  _nab = list(map(int, input().split()))
  assert(len(_nab) == 3)
  _n = _nab[0]
  _a = _nab[1]
  _b = _nab[2]
  assert(_n <= 10000 and _n > 0)
  assert(_a <= _b and _a > 0 and _b > 0 and _a <= 36 and _b <= 36)

  num_list = [i+1 for i in range(_n)]
  calc(num_list, _a, _b)
