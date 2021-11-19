use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {l: u32};
  let cnt = loop_dp(l as usize - 1, 11);
  writeln!(out, "{}", cnt).unwrap();
}

fn loop_dp(points: usize, choice: usize) -> usize {
  let mut cnt: Vec<Vec<usize>> = Vec::new();
  for i in 0..points + 1 {
    cnt.push(
      (0..choice + 1)
        .map(|j| {
          if j == 0 {
            return 1;
          }
          if i == 0 {
            return 0;
          }
          return cnt[i - 1][j - 1] + cnt[i - 1][j];
        })
        .collect(),
    );
    // for j in 0..choice + 1 {
    //   if(j == 0){

    //   }
    // }
  }
  cnt[points][choice]
}
