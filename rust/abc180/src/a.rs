use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: u32, a: u32, b: u32};
  writeln!(out, "{}", n - a + b).unwrap();
}
