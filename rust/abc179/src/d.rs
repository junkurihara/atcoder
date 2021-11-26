use proconio::input;
use std::io::{stdout, BufWriter, Write};

const div: usize = 998244353;

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, k: usize};
  input! {lr: [(usize, usize); k]};
  let mut lr_vec: Vec<usize> = Vec::new();

  for p in lr {
    for i in p.0..p.1 + 1 {
      lr_vec.push(i);
    }
  }
  let min_val = lr_vec.clone().into_iter().min().unwrap();

  let mut dp: Vec<usize> = (0..n).into_iter().map(|_| 0).collect();
  for i in 0..n {
    if i == 0 {
      dp[i] = 1;
    }
    if i + min_val < n {
      for x in &lr_vec {
        if i + *x < n {
          dp[*x + i] = (dp[*x + i] + dp[i]) % div;
        }
      }
    }
  }
  writeln!(out, "{}", dp[n - 1]).unwrap();
}
