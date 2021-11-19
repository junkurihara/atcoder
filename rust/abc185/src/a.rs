use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {a: [u32; 4]};
  writeln!(out, "{}", a.iter().min().unwrap()).unwrap();
}
