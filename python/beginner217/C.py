if __name__ == "__main__":
  _n = int(input())
  _ps = list(map(int, input().split()))

  # query by p_i then obtain i
  _ps_dict = {str(val-1): idx+1 for idx,val in enumerate(_ps)}
  for q_idx in range(_n):
    if q_idx != _n-1:
      print(_ps_dict.get(str(q_idx)), end=" ")
    else:
      print(_ps_dict.get(str(q_idx)))
