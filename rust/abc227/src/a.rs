use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, k: usize, a: usize}

  let p = (a + k - 1) % n;
  if p != 0 {
    writeln!(out, "{}", p).unwrap();
  } else {
    writeln!(out, "{}", n).unwrap();
  }
}
