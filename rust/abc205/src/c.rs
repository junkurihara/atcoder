use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  input! {a: i64, b: i64, c: u64}
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  // a.pow(c) ? b.pow(c)
  if c % 2 == 0 || (a >= 0 && b >= 0) {
    if a.abs() > b.abs() {
      writeln!(out, ">").unwrap();
    } else if a.abs() == b.abs() {
      writeln!(out, "=").unwrap();
    } else {
      writeln!(out, "<").unwrap();
    }
  } else if a >= 0 && b >= 0 {
    writeln!(out, ">").unwrap();
  } else if a < 0 && b >= 0 {
    writeln!(out, "<").unwrap();
  } else {
    if a < b {
      writeln!(out, "<").unwrap();
    } else if a == b {
      writeln!(out, "=").unwrap();
    } else {
      writeln!(out, ">").unwrap();
    }
  }
}
