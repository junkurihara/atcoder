use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: u32}
  let inc = n - 1;

  writeln!(out, "{}", (inc - inc % 100) / 100 + 1).unwrap();
}
