use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {s: Chars}
  assert_eq!(s.len(), 3);

  writeln!(
    out,
    "{}",
    if s[0] == s[1] && s[1] == s[2] {
      1
    } else if s[0] == s[1] || s[1] == s[2] || s[0] == s[2] {
      3
    } else {
      6
    }
  );
}
