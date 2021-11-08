use proconio::input;
use std::collections::HashSet;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize}
  let mut hs: HashSet<Vec<usize>> = HashSet::new();
  for _ in 0..n {
    input! {l: usize}
    input! {a: [usize; l]}
    hs.insert(a);
  }
  writeln!(out, "{}", hs.len()).unwrap();
}
