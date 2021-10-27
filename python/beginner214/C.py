def find_min_time(prv_time, time_from_prv, t_list, p_idx):
  return min(prv_time+time_from_prv, t_list[p_idx])


if __name__ == "__main__":
  _n = int(input())
  _ss = list(map(int, input().split()))
  _ts = list(map(int, input().split()))
  min_time = min(_ts)
  start_from_idxs = [idx for idx, v in enumerate(_ts) if v == min_time]
  start_from = start_from_idxs[0]

  receive_time = [0 for _ in range(_n)]
  receive_time[start_from] = _ts[start_from]

  for p_idx in range(_n)[1:]:
    current_idx = (start_from + p_idx ) % _n
    prv_idx = (start_from + p_idx - 1) % _n
    time_from_prv = _ss[prv_idx]
    received_at = find_min_time(receive_time[prv_idx], time_from_prv, _ts, current_idx)
    receive_time[current_idx] = received_at

  for t in receive_time:
    print(t)
