def check_same(list_num):
  return all([elem == list_num[0] for elem in list_num[1:]])

def check_increment(list_num, base):
  return all([
    (elem + 1) % base == list_num[(idx + 1)]
    for idx, elem in enumerate(list_num[:-1])
  ])

if __name__ == "__main__":
  pswd = list(map(int, list(input())))
  if check_same(pswd) or check_increment(pswd, 10):
    print("Weak")
  else:
    print("Strong")
