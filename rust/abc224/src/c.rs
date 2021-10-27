use proconio::input;
use itertools::Itertools;

pub fn c_main(){
  input!{
    n: usize
  }
  assert!(n >= 3 && n <= 300);

  let mut points = Vec::new();
  for i in 0..n {
    input!{
      p: [i64; 2]
    }
    points.push(Point{x: p[0], y: p[1]});
  }

  let mut cnt = 0;
  for comb in points.iter().combinations(3) {
    if !comb[0].is_linear(comb[1], comb[2]) {
      cnt += 1;
    }
  }
  println!("{}", cnt);

}

#[derive(Debug, Clone, Copy)]
struct Point {
  x: i64,
  y: i64
}

impl Point {
  pub fn is_linear(&self, p1: &Point, p2: &Point) -> bool {
    let new_p1 = Point{x: p1.x - self.x, y: p1.y - self.y};
    let new_p2 = Point{x: p2.x - self.x, y: p2.y - self.y};
    // y = ax + b defined by new_p1, new_p2
    // if b != 0, ok.
    // y1 = a x1 + b
    // y2 = a x2 + b
    // y1 - y2 = a(x1 - x2)

    // if p1.x == p2.x, then p1.y != p2.y
    if new_p1.x == new_p2.x && new_p1.x != 0 && new_p2.x != 0 {
      return false
    };
    assert!(
      (new_p1.x - new_p2.x) * new_p1.y - (new_p1.y - new_p2.y) * new_p1.x
      == (new_p1.x - new_p2.x) * new_p2.y -  (new_p1.y - new_p2.y) * new_p2.x
    );

    if (new_p1.x - new_p2.x) * new_p1.y - (new_p1.y - new_p2.y) * new_p1.x != 0 {
      false
    }
    else {
      true
    }
  }

}
