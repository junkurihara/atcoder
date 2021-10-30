use proconio::input;
// use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize}
  let mut lr: Vec<(u64, u64)> = Vec::with_capacity(n);
  for _ in 0..n {
    input! {t: u64, l: u64, r: u64}
    match t {
      1 => lr.push((l << 1, r << 1)),
      2 => lr.push((l << 1, (r << 1) - 1)),
      3 => lr.push(((l << 1) + 1, r << 1)),
      _ => lr.push(((l << 1) + 1, (r << 1) - 1)),
    }
  }

  lr.sort();

  let mut cnt = 0;
  for i in 0..n {
    let ptr = lr[i];
    for j in i + 1..n {
      let cmp = lr[j];
      if ptr.1 >= cmp.0 {
        cnt += 1;
      }
    }
  }

  // writeln!(out, "{:?}", lr);
  writeln!(out, "{}", cnt).unwrap();
}
