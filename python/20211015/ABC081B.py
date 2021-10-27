def get_factor_two(num, pow):
  if num % 2 == 0:
    return get_factor_two(num / 2, pow + 1)
  else:
    return pow


if __name__ == "__main__":
  _n = int(input())
  assert(_n > 0 and _n <= 200)
  _as = list(map(int, input().split()))
  assert(len(_as) == _n)
  assert( all([elem > 0 and elem <= 1000000000 for elem in _as]) )

  print(min([get_factor_two(elem, 0) for elem in _as]))
