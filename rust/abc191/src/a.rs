use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {a: usize, b: usize}

  writeln!(out, "{}", 100f64 * (a as f64 - b as f64) / (a as f64)).unwrap();
}
