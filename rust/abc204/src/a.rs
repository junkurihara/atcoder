use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {x: u8, y: u8}

  if x != y {
    writeln!(out, "{}", 3 - x - y).unwrap();
  } else {
    writeln!(out, "{}", x).unwrap();
  }
}
