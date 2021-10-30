use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {abc: [u8; 3]}
  let mut cloned = abc.clone();
  cloned.sort();
  writeln!(out, "{}", cloned[2] + cloned[1]).unwrap();
}
