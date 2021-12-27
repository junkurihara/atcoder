// use itertools::Itertools;
use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {l: usize, r: usize}
  input! {s: Chars}

  let mut cnt = 0;
  for i in 0..s.len() {
    write!(
      out,
      "{}",
      if i + 1 < l {
        s[i]
      } else if i + 1 > r {
        s[i]
      } else {
        let res = s[r - 1 - cnt];
        cnt += 1;
        res
      }
    )
    .unwrap();
  }
  writeln!(out, "").unwrap();
}
