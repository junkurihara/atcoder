use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! { n: usize, k: usize, a: [usize; n]}
  let mut indexed: Vec<(usize, usize, usize)> =
    a.into_iter().enumerate().map(|(i, v)| (i, v, 0)).collect();
  let r = k % n;
  let f = (k - r) / n;
  indexed.sort_by_cached_key(|(_, v, _)| *v);
  for i in 0..r {
    indexed[i].2 = 1;
  }

  indexed.sort_by_cached_key(|(i, _, _)| *i);
  for i in indexed {
    writeln!(out, "{}", f + i.2).unwrap();
  }
}
