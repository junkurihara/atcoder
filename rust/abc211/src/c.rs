use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  // DPよくわかってない

  writeln!(out, "{}", 0).unwrap();
}
