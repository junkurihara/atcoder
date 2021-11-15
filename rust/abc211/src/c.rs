use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

const word: &str = "chokudai";

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {source: Chars}
  let target: Vec<char> = String::from(word).chars().collect();
  let div: usize = 10usize.pow(9) + 7;

  // DP
  let mut cnt: Vec<Vec<usize>> = Vec::new();
  for i in 0..source.len() + 1 {
    let local: Vec<usize> = (0..target.len() + 1)
      .map(|j| {
        if j == 0 {
          return 1;
        }
        if i == 0 {
          return 0;
        }
        if source[i - 1] == target[j - 1] {
          return (cnt[i - 1][j - 1] + cnt[i - 1][j]) % div;
        }
        return cnt[i - 1][j];
      })
      .collect();
    cnt.push(local);
  }

  writeln!(out, "{}", cnt[source.len()][target.len()]).unwrap();
}
