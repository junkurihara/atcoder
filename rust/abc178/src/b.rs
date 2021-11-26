use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {a: isize, b: isize, c: isize, d: isize};
  writeln!(out, "{}", (a * c).max(a * d).max(b * c).max(b * d)).unwrap();
}
