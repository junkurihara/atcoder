def check_product_even_odd(a, b):
  if a % 2 == 0 or b % 2 == 0:
    print("Even")
  else:
    print("Odd")

if __name__ == "__main__":
  _ab = list(map(int, input().split()))
  assert(len(_ab) == 2)
  a = _ab[0]
  b = _ab[1]
  assert(a >= 1 and a <= 10000 and b >= 1 and b <= 10000)
  check_product_even_odd(a,b)
