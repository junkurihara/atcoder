if __name__ == "__main__":
  _n = int(input())
  assert(_n > 0 and _n <= 100)
  _discs = [0] * _n
  for idx, disc in enumerate(_discs):
    disc = int(input())
    assert(disc > 0 and disc <= 100)
    _discs[idx] = disc

  non_duplicated = list(set(_discs))
  print(len(non_duplicated))
