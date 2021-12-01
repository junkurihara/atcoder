use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, x: usize, t: usize};
  let total = if n % x > 0 {
    t + t * (n - n % x) / x
  } else {
    t * (n - n % x) / x
  };
  writeln!(out, "{}", total).unwrap();
}
