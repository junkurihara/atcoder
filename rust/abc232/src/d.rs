// use itertools::Itertools;
use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {h: usize, w: usize}
  input! {c: [Chars; h]}

  let mut dp: Vec<Vec<usize>> = (0..h + 1)
    .map(|_| (0..w + 1).map(|_| 0).collect())
    .collect();

  for row_idx in (0..h).rev() {
    for col_idx in (0..w).rev() {
      if c[row_idx][col_idx] == '.' {
        dp[row_idx][col_idx] = dp[row_idx + 1][col_idx].max(dp[row_idx][col_idx + 1]) + 1;
      }
    }
  }

  writeln!(out, "{}", dp[0][0]).unwrap();
}
