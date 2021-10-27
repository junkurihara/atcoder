def find_max_next(target_idx_list, array):
  next_idxs = [(idx+1) % len(array) for idx in target_idx_list]
  next_values = [array[idx] for idx in next_idxs]
  next_max_idxs = [next_idxs[i] for i, v in enumerate(next_values) if v == max(next_values)]
  if len(next_max_idxs) == 1:
    return next_max_idxs[0] - 1
  else:
    return find_max_next(next_max_idxs, array) - 1

def find_min_next(target_idx_list, array):
  next_idxs = [(idx+1) % len(array) for idx in target_idx_list]
  next_values = [array[idx] for idx in next_idxs]
  next_min_idxs = [next_idxs[i] for i, v in enumerate(next_values) if v == min(next_values)]
  if len(next_min_idxs) == 1:
    return next_min_idxs[0] - 1
  else:
    return find_min_next(next_min_idxs, array) - 1


if __name__ == "__main__":
  _x = list(input())
  ord_x = list(map(ord, _x))
  max_idxs = [idx for idx, val in enumerate(ord_x) if val == max(ord_x)]
  min_idxs = [idx for idx, val in enumerate(ord_x) if val == min(ord_x)]
  true_max_idx = find_max_next(max_idxs, ord_x)
  true_min_idx = find_min_next(min_idxs, ord_x)

  max_str = _x[true_max_idx:] + _x[:true_max_idx]
  min_str = _x[true_min_idx:] + _x[:true_min_idx]

  print("".join(min_str))
  print("".join(max_str))
