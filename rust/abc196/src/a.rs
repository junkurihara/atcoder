use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {_a: i32, b: i32, c: i32, _d: i32}

  writeln!(out, "{}", b - c).unwrap();
}
