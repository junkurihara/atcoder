use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {m: usize, h: usize}

  if h % m == 0 {
    writeln!(out, "Yes").unwrap();
  } else {
    writeln!(out, "No").unwrap();
  }
}
