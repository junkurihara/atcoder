use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {s1: Chars, s2: Chars};
  for s in s1.iter().enumerate() {
    if *s.1 == '#' {
      if !(s2[s.0] == '#' || s1[(s.0 + 1) % 2] == '#') {
        writeln!(out, "No").unwrap();
        return;
      }
    }
  }
  for s in s2.iter().enumerate() {
    if *s.1 == '#' {
      if !(s1[s.0] == '#' || s2[(s.0 + 1) % 2] == '#') {
        writeln!(out, "No").unwrap();
        return;
      }
    }
  }
  writeln!(out, "Yes").unwrap();
}
