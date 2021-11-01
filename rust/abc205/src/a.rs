use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {a: u16, b: u16}

  writeln!(out, "{}", (b as f64) * (a as f64) / 100f64).unwrap();
}
