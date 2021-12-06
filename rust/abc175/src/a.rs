use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {s: Chars};
  let sumR = s
    .iter()
    .fold(0, |acc, i| if *i == 'R' { acc + 1 } else { acc });
  if s[1] == 'R' && sumR > 1 {
    writeln!(out, "{}", sumR).unwrap();
    return;
  }

  if sumR > 0 {
    writeln!(out, "1").unwrap();
    return;
  }
  writeln!(out, "0").unwrap();
}
