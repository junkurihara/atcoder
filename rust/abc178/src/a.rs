use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {x: u32};
  writeln!(out, "{}", if x == 0 { 1 } else { 0 }).unwrap();
}
