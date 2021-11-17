use proconio::input;

use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, s: usize, d: usize};
  input! {xy: [(usize, usize); n]}

  if xy.into_iter().any(|(x, y)| x < s && y > d) {
    writeln!(out, "Yes").unwrap();
  } else {
    writeln!(out, "No").unwrap();
  }
}
