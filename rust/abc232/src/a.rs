use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {s: Chars}
  let a = (*s.get(0).unwrap()).to_digit(10).unwrap();
  let b = (*s.get(2).unwrap()).to_digit(10).unwrap();

  writeln!(out, "{}", a * b).unwrap();
}
