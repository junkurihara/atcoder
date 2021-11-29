use proconio::input;
use std::cmp::Reverse;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, w: usize};
  input! {ab: [(usize, usize); n]}

  let mut sorted_ab: Vec<(usize, usize)> = ab.clone();
  sorted_ab.sort_by_key(|(a, _)| Reverse(*a));

  let mut remain_w = w;
  let mut sum_a = 0;
  for c in sorted_ab {
    if remain_w > 0 {
      let max_cnt = remain_w.min(c.1);
      sum_a += max_cnt * c.0;
      remain_w -= max_cnt;
    }
  }
  writeln!(out, "{}", sum_a).unwrap();
}
