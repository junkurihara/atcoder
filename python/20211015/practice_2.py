# N,Q = (26,1000), (26,100), (5,7)
import os

global_cnt = 0
max_query = 0
ball_num = 0

def init_labels():
  base = ord("A")
  labeled_balls = [chr(base+idx) for idx in range(ball_num)]
  return labeled_balls

def find_bigger(pvt_label, given_list):
  global global_cnt
  for idx, label in enumerate(given_list):
    global_cnt = global_cnt + 1
    assert(global_cnt <= max_query)
    print("? %s %s" % (pvt_label, label))
    weight_of_label = input()
    assert(weight_of_label == ">" or weight_of_label == "<")
    if weight_of_label == "<":
      return idx

def find_smaller(pvt_label, given_list):
  global global_cnt
  for idx, label in enumerate(reversed(given_list)):
    global_cnt = global_cnt + 1
    assert(global_cnt <= max_query)
    print("? %s %s" % (pvt_label, label))
    weight_of_label = input()
    assert(weight_of_label == ">" or weight_of_label == "<")
    if weight_of_label == ">":
      return idx

def sort_sublist(pvt, sublist):
  sliced = sublist[0:pvt] + sublist[pvt+1:]

  # indexes in slice
  found_bigger_idx = find_bigger(sublist[pvt], sliced)
  found_smaller_idx_reversed = find_smaller(sublist[pvt], sliced)
  found_smaller_idx = len(sliced) - found_smaller_idx_reversed - 1
  # swap
  if found_bigger_idx < found_smaller_idx:
      tmp = sliced[found_bigger_idx]
      sliced[found_bigger_idx] = sliced[found_smaller_idx]
      sliced[found_smaller_idx] = tmp

  else:
    new_pvt = int(len(sliced[:pvt-1])/2)
    sort_sublist(new_pvt, sliced[:pvt-1])





def interactive_sort():
  labeled_balls = init_labels()

  # quick sort
  pvt = int(ball_num/2) - 1
  sort_sublist(pvt, labeled_balls)





    # cnt += found_diff_idx+1
    # 2 balls output

    # swap ball index

    # evaluate condition to finish

if __name__=="__main__":
  _n, _q = map(int, input().split())
  assert((_n,_q)==(26,1000) or (_n,_q)==(26,100) or (_n,_q)==(5,7))
  max_query = _q
  ball_num = _n
  os.system("clear")
  print(_n, _q)
  interactive_sort()
