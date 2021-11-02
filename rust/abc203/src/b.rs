use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, k: u32}

  let hundreds = k * n * (n + 1) * 100 / 2;
  let ones = n * k * (k + 1) / 2;

  writeln!(out, "{}", hundreds + ones).unwrap();
}
