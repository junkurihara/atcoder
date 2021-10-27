use proconio::input;
use std::cmp::Reverse;

#[derive(Debug, Clone)]
struct Player {
  index: usize,
  play: Vec<i32>,
  wins: usize,
}

impl Player {
  pub fn new(index: usize, pattern: String) -> Player {
    let play = pattern
      .chars()
      .map(|c| match c {
        'G' => 2i32,
        'C' => 1i32,
        'P' => 0i32,
        _ => {
          panic!("invalid")
        }
      })
      .collect();
    Player {
      index,
      play,
      wins: 0,
    }
  }
}

pub fn c_main() {
  input! {
    n: usize,
    m: usize
  }
  input! {
    players_strings: [String; 2*n]
  }
  let mut players: Vec<Player> = players_strings
    .into_iter()
    .enumerate()
    .map(|p| Player::new(p.0 + 1, p.1))
    .collect();

  for stage in 0..m {
    for i in 0..n {
      let diff = (players[2 * i].play[stage] - players[2 * i + 1].play[stage]).abs();
      match diff {
        0 => {}
        1 => {
          if players[2 * i].play[stage] > players[2 * i + 1].play[stage] {
            players[2 * i].wins += 1;
          } else {
            players[2 * i + 1].wins += 1;
          }
        }
        2 => {
          if players[2 * i].play[stage] < players[2 * i + 1].play[stage] {
            players[2 * i].wins += 1;
          } else {
            players[2 * i + 1].wins += 1;
          }
        }
        _ => panic!("invalid data"),
      }
    }
    players.sort_by_key(|x| (Reverse(x.wins), x.index));
  }
  for p in players {
    println!("{}", p.index);
  }
}
