use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! { a: f64, b: f64 }

  writeln!(out, "{}", b + (a - b) / 3.0f64).unwrap();
}
