class Point:
  def __init__(self, t, x, y):
    self.t = t
    self.x = x
    self.y = y

def calc(plan):
  for idx, current in enumerate(plan):
    if idx < len(plan)-1:
      nexthop = plan[idx+1]
      duration = nexthop.t - current.t
      distance = abs(nexthop.x - current.x) + abs(nexthop.y - current.y)
      diff = duration - distance
      # judge
      if diff >= 0 and diff % 2 == 0:
        continue
      else:
        print("No")
        return
    else:
      print("Yes")

if __name__ == "__main__":
  _n = int(input())
  _txy_list = [Point(0, 0, 0)]
  for idx in range(_n):
    txy = list(map(int, input().split()))
    _txy_list.append(Point(
      txy[0], txy[1], txy[2]
    ))

  calc(_txy_list)
