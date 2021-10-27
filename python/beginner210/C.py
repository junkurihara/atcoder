def cnt_dict(window_s):
  dict_s = dict()
  for p in window_s:
    if dict_s.get(p) is None:
      dict_s[p] = 1
    else:
      dict_s[p] += 1

  return dict_s

if __name__ == "__main__":
  _n, _k = map(int, input().split())
  _cs = list(map(int, input().split()))

  window = cnt_dict(_cs[:_k])
  maxim = len(window)

  for idx, val in list(enumerate(_cs))[1:_n-_k+1]:
    # print(idx, idx+_k-1)
    if window.get(_cs[idx+_k-1]) is None:
      window[_cs[idx+_k-1]] = 1
    else:
      window[_cs[idx+_k-1]] += 1

    if window.get(_cs[idx-1]) == 1:
      del window[_cs[idx-1]]
    else:
      window[_cs[idx-1]] -= 1

    if maxim < len(window):
      maxim = len(window)

    # print(idx, window)

  print(maxim)
