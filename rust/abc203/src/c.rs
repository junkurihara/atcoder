use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, k: usize, ab: [(usize, usize); n]}
  let mut ab_compressed: HashMap<usize, usize> = HashMap::new();
  for (i, money) in ab {
    *ab_compressed.entry(i).or_insert(0) += money;
  }
  let mut ab_sorted: Vec<(usize, usize)> = ab_compressed.into_iter().collect();
  ab_sorted.sort_by_key(|(i, _)| *i);

  let mut sum = k;
  for (i, money) in ab_sorted {
    if i > sum {
      break;
    }
    sum += money;
  }
  writeln!(out, "{}", sum).unwrap();
}
