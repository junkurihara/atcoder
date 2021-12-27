// use itertools::Itertools;
use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: u64, x: u64}
  let mut vect_l: Vec<Vec<u64>> = Vec::new();
  for _ in 0..n {
    input! {l_ith: u64}
    let mut a_ith: Vec<u64> = Vec::new();
    for _ in 0..l_ith {
      input! {a_ij: u64};
      if x >= a_ij && x % a_ij == 0 {
        a_ith.push(a_ij)
      }
    }
    vect_l.push(a_ith);
  }
  writeln!(out, "{}", dfs(vect_l, x, 0, 1)).unwrap();
}

fn dfs(vect: Vec<Vec<u64>>, target: u64, position: usize, product: u64) -> u64 {
  if position == vect.len() {
    if product == target {
      return 1u64;
    } else {
      return 0u64;
    }
  }

  let local_vect = vect.get(position).unwrap();
  let mut local_sum = 0;
  for l in local_vect {
    if product <= target / l {
      local_sum += dfs(vect.clone(), target, position + 1, product * l);
    }
  }
  return local_sum;
}
