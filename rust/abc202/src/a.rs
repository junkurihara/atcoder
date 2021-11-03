use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {a: u8, b: u8, c: u8}
  writeln!(out, "{}", 21 - a - b - c).unwrap();
}
