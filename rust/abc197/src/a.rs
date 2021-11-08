use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {s: Chars}
  let mut rotated: Vec<char> = Vec::with_capacity(3);
  rotated.extend_from_slice(&s[1..3]);
  rotated.extend_from_slice(&s[..1]);
  writeln!(out, "{}", rotated.iter().collect::<String>()).unwrap();
}
