if __name__ == "__main__":
  _n = int(input())
  _, hex_str_n = bin(_n).split("b")
  print(len(hex_str_n)-1)
