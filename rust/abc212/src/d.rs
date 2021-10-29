use proconio::input;
use std::cmp::Reverse;
use std::collections::BinaryHeap;

pub fn main() {
  input! {q: usize}
  let mut queries: Vec<(u8, i64)> = Vec::new();
  for _ in 0..q {
    input! {p: u8}
    if p == 3 {
      queries.push((p, 0))
    } else {
      input! {x: i64}
      queries.push((p, x));
    }
  }

  let mut compressed: BinaryHeap<Reverse<i64>> = BinaryHeap::new();
  let mut diff = 0;
  for (p, x) in queries {
    if p == 3 {
      // compressed.sort_by_key(|(val, d)| *val + diff - d);
      // compressed.reverse();
      // println!("{:?}", compressed);
      let minim = compressed.pop().unwrap();
      println!("{:?}", minim.0 + diff);
      // compressed.push((0, diff));
    } else if p == 2 {
      diff += x;
    } else {
      // println!("x, diff = {}, {}", x, diff);
      compressed.push(Reverse(x - diff));
    }
  }

  // println!("{:?}", compressed.pop());

  /*
  1 3   3 # (diff=3 3)
  1 5   5 # (diff=3 3, diff=3 5)
  3     3 diff=3 pop=3 (5)
  2 2   2 diff=3
  3     3 diff=1 pop=7=5+diff3-diff1 ()
  1 4   1 # (diff=1 4)
  2 1   2 diff=1
  1 3   1 # (diff=0 3, diff=1 4)
  3     3 diff=0 pop=3=4+diff0-diff0 ()
  8
  1 3
  1 5
  3
  1 2
  2 2
  1 1
  2 3
  3
  */
}
