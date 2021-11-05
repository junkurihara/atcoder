use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {a: u32, b: u32, c: u32}

  if a.pow(2) + b.pow(2) < c.pow(2) {
    writeln!(out, "Yes").unwrap();
  } else {
    writeln!(out, "No").unwrap();
  }

}
