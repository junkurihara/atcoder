use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {x: f32}
  let p0 = x.floor() as u32;
  let p1 = ((x * 10f32).floor() as u32) % 10;
  if p1 > 4 {
    writeln!(out, "{}", p0 + 1).unwrap();
  } else {
    writeln!(out, "{}", p0).unwrap();
  }
}
