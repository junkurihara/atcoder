use proconio::input;
// use proconio::marker::Chars;
// use itertools::Itertools;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {t: isize}
  writeln!(out, "{}", fx(fx(fx(t)+t) + fx(fx(t)))).unwrap();
}

pub fn fx(x: isize) -> isize {
  x*x + 2*x + 3
}
