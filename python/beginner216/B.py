if __name__ == "__main__":
  _n = int(input())
  name_dict = {}
  for _ in range(_n):
    _s, _t = input().split()
    if name_dict.get(_s) is None:
      name_dict[_s] = set()
      name_dict[_s].add(_t)
    else:
      given_name_set = name_dict[_s]
      if {_t}.issubset(given_name_set):
        print("Yes")
        quit()
      else:
        given_name_set.add(_t)
        name_dict[_s] = given_name_set
  print("No")
