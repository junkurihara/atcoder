use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, s: Chars}

  for (i, c) in s.iter().enumerate() {
    if *c == '1' {
      if i % 2 == 0 {
        writeln!(out, "Takahashi").unwrap();
      } else {
        writeln!(out, "Aoki").unwrap();
      }
      break;
    }
  }
}
