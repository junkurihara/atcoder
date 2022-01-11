use itertools::Itertools;
use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize}
  input! {xy: [(isize, isize); n]}
  let max_val = xy
    .into_iter()
    .combinations(2)
    .map(|v| distance(v[0], v[1]))
    .max()
    .unwrap();

  writeln!(out, "{}", (max_val as f64).sqrt()).unwrap();
}

pub fn distance(p1: (isize, isize), p2: (isize, isize)) -> usize {
  let x = p1.0 - p2.0;
  let y = p1.1 - p2.1;
  return (x * x + y * y) as usize;
}
