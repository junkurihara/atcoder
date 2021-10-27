DIV = 10 ** 9 + 7

def get_idx_list(list_s, char):
  return [idx for idx, key in enumerate(list_s) if key == char]

def rcv_search(idx_lists, root):
  if len(idx_lists) == 1:
    return len([p for p in idx_lists[0] if p > root]) % DIV
  else:
    total = 0
    for p in idx_lists[0]:
      if p > root:
        total += rcv_search(idx_lists[1:], p) % DIV
    return total % DIV

if __name__ == "__main__":
  # _s = list(input())
  _s = "chokudaichokudaichokudai"
  chokudai = list("chokudai")

  idx_lists = []
  for p in chokudai:
    idx_lists.append(get_idx_list(_s, p))
  print(idx_lists)
  total = 0
  for p in idx_lists[0]:
    print(total)
    total += rcv_search(idx_lists[1:], p) % DIV

  print(total)
