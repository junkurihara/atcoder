from functools import reduce

class coin:
  def __init__(self, coef, num):
    self.coef = coef
    self.num = num

def search_combination(coins, target):
  cnt = 0
  for i in range(coins[0].num+1):
    if len(coins) > 1:
      remains = target - (coins[0].coef * i)
      arr = coins[1:]
      remains_maximum_possible = reduce( lambda accum, x: accum + (x.num * x.coef), arr, 0)
      if remains <= remains_maximum_possible:
        cnt += search_combination(arr, remains)
      else:
        continue
    else:
      if i * coins[0].coef == target:
        return 1

  return cnt


if __name__=="__main__":
  _a = int(input())
  _b = int(input())
  _c = int(input())
  _x = int(input())
  assert(_a >= 0 and _b >= 0 and _c >= 0)
  assert(_a <= 50 and _b <= 50 and _c <= 50)
  assert(_a+_b+_c >= 1)
  assert(_x >= 50 and _x <= 20000)
  assert(_x % 50 == 0)
  # satisfy _x = 500 a + 100 b + 50 c under the condition of a < _a, b < _b and c < _c
  coin_500 = coin(500, _a)
  coin_100 = coin(100, _b)
  coin_50 = coin(50, _c)
  coins = [coin_500, coin_100, coin_50]
  cnt = search_combination(coins, _x)
  print(cnt)
