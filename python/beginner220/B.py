def list_to_num(base, listnum):
  n = 0
  for ord, coef in enumerate(listnum):
    n += coef * (base ** ord)
  return n

def calc(base, a, b):
  a_list = reversed(list(map(int, list(str(a)))))
  b_list = reversed(list(map(int, list(str(b)))))

  a_10 = list_to_num(base,a_list)
  b_10 = list_to_num(base,b_list)

  print(a_10 * b_10)


if __name__ == '__main__':
  _k = int(input())
  _a, _b = map(int, input().split())

  calc(_k, _a, _b)
