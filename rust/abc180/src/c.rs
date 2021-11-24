use proconio::input;
use std::collections::HashSet;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize};
  let sq = ((n as f64).sqrt().ceil() + 1.0f64) as usize;

  let mut hs: HashSet<usize> = HashSet::new();
  for i in 1..sq + 1 {
    if n % i == 0 {
      hs.insert(i);
      hs.insert(n / i);
    }
  }
  let mut x: Vec<usize> = hs.into_iter().collect();
  x.sort();
  for m in x {
    writeln!(out, "{}", m).unwrap();
  }
}
