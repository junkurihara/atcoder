use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {s: Chars, k: usize};

  let n = s.len();
  let mut acc_blanks: Vec<usize> = Vec::with_capacity(n + 1);
  acc_blanks.push(0);
  let mut cnt = 0;
  for c in s {
    if c == '.' {
      cnt += 1;
    }
    acc_blanks.push(cnt);
  }

  let mut ptr_r = 0;
  let mut max_cnt = 0;
  for ptr_l in 0..n {
    while ptr_r < n && acc_blanks.get(ptr_r + 1).unwrap() - acc_blanks.get(ptr_l).unwrap() <= k {
      ptr_r += 1;
    }
    max_cnt = (ptr_r - ptr_l).max(max_cnt);
  }
  writeln!(out, "{}", max_cnt).unwrap();
}
