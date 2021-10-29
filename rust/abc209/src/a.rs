use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {a: u32, b: u32}

  if a > b {
    writeln!(out, "0");
  } else {
    writeln!(out, "{}", b - a + 1).unwrap();
  }
}
