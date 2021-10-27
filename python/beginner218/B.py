if __name__ == "__main__":
  _ss = list(map(int, input().split()))
  base_a = ord("a")
  _ss_mapped = [
    chr(elem - 1 + base_a) for elem in _ss
  ]

  print("".join(_ss_mapped))
