use proconio::input;

use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize};
  input! {apx: [(usize, usize, usize);n]}
  let min_p: Option<usize> = apx
    .iter()
    .filter(|(a, _, x)| x > a)
    .map(|(_, p, _)| *p)
    .min();
  if let Some(p) = min_p {
    writeln!(out, "{}", p).unwrap();
  } else {
    writeln!(out, "-1").unwrap();
  }
}
