class Player:
  def __init__(self, gcp):
    self.gcp = self.set_gcp(gcp)
    self.count = 0

  def set_gcp(self, gcp):
    mapped = []
    for i in gcp:
      if i == "G":
        mapped.append(2)
      if i == "C":
        mapped.append(1)
      if i == "P":
        mapped.append(0)
    return mapped


if __name__ == "__main__":
  _nm = list(map(int, input().split()))
  # should assert
  _n = _nm[0]
  _m = _nm[1]
  players = []
  for idx in range(2*_n):
    gcp = list(input())
    players.append(Player(gcp))

  order = [i for i in range(2*_n)]

  for round in range(_m):
    wins = [[]] + [ [] for _ in range(round + 1)]

    for p_idx in range(_n):
      player_a = players[order[2 * p_idx]]
      player_b = players[order[2 * p_idx + 1]]

      diff = player_a.gcp[round] - player_b.gcp[round]
      if abs(diff) == 1:
        if diff > 0:
          player_a.count += 1
        else:
          player_b.count += 1
      elif abs(diff) == 2:
        if diff > 0:
          player_b.count += 1
        else:
          player_a.count += 1

      wins[player_a.count].append(order[2*p_idx])
      wins[player_b.count].append(order[2*p_idx + 1])

    sorted_wins = [ sorted(s) for s in wins ]
    order = []
    for w in reversed(sorted_wins):
      order += w

  for p_idx in order:
    print(p_idx + 1)
