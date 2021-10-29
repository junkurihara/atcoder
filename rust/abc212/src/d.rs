use proconio::input;

pub fn main() {
  input! {q: usize}
  let mut queries: Vec<(u8, i64)> = Vec::with_capacity(q);
  for _ in 0..q {
    input! {p: u8}
    if p == 3 {
      queries.push((p, 0))
    } else {
      input! {x: i64}
      queries.push((p, x));
    }
  }
  queries.reverse();
  let mut compressed: Vec<(i64, i64)> = Vec::new();
  let mut cnt3 = 0;
  let mut diff = 0;
  for (p, x) in queries {
    if p == 1 {
      println!("{} (p, x) = ({}, {})", diff, p, x);
      compressed.push((x, diff));
    } else if p == 2 {
      diff += x;
    } else {
      cnt3 += 1
    }
  }
  // compressed.sort_by_key(|(x, _)| *x - diff);
  println!("{:?}", compressed);
  // for i in 0..cnt3 {
  //   println!("{}", compressed[i].0 + diff);
  // }
  // println!("{}", diff);
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
