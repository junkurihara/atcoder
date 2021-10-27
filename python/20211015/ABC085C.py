# 10 a + 5 b +  c = _yp
#    a +   b +  c = _n
# ->
#  9 a + 4 b      = _yp - _n
# ->
# a = (_yp - _n - 4b)/9
def calc(n, yp):
  yp_minus_n = yp - n

  for a in range(n+1):
    for b in range(n-a+1):
      if 9 * a + 4 * b == yp_minus_n:
        c = n - a - b
        if c >= 0:
          print('{} {} {}'.format(a, b, c))
          return
  # max_a = int(yp_minus_n / 9)
  # for a in range(min(n, max_a)+1):
  #   diff = int(yp_minus_n - 9 * a)
  #   diff_o = int(diff / 4)
  #   if diff >= 0 and diff % 4 == 0 and diff_o <= n - a:
  #     xa = a
  #     xb = diff_o
  #     xc = n - xa - xb
  #     print(xa, xb, xc)
  #     return

  print(-1, -1, -1)


if __name__ == "__main__":
  _ny = list(map(int, input().split()))
  # assert(len(_ny) == 2)
  _n = _ny[0]
  _y = _ny[1]
  # assert(_y >= 1000 and _y <= 20000000 and _y % 1000 == 0)
  _yp = int(_y / 1000)
  calc(_n, _yp)
