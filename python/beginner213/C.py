def str_to_dec_int(str_int):
  return int(str_int) - 1

def get_mapped_line_dict(non_null_idx):
  mapped_dict = dict()
  for i, line_idx in enumerate(non_null_idx):
    mapped_dict[line_idx] = i
  return mapped_dict

if __name__ == "__main__":
  _h, _w, _n = map(int, input().split())
  positions = [
    list(map(str_to_dec_int, input().split()))
    for _ in range(_n)
  ]

  non_null_row = sorted(list({p[0] for p in positions}))
  non_null_col = sorted(list({p[1] for p in positions}))
  map_row = get_mapped_line_dict(non_null_row)
  map_col = get_mapped_line_dict(non_null_col)

  for p in positions:
    print(
      map_row[p[0]]+1,
      map_col[p[1]]+1
    )
