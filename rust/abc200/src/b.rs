use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, k: usize}
  let mut current = n;

  for _ in 0..k {
    if current % 200 == 0 {
      current /= 200;
    } else {
      current = current * 1000 + 200;
    }
  }
  writeln!(out, "{}", current).unwrap();
}
