if __name__ == "__main__":
  input_set = set()
  for _ in range(4):
    input_set.add(input())
  print("Yes") if len(input_set) == 4 else print("No")
