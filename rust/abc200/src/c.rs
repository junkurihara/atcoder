use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, a: [usize; n]}
  let mut res_hs: HashMap<usize, usize> = HashMap::new();

  for (i, val) in a.iter().enumerate() {
    let r = *val % 200;
    *res_hs.entry(r).or_insert(0) += 1;
  }

  let mut cnt = 0;
  for elem in res_hs {
    cnt += elem.1 * (elem.1 - 1) / 2;
  }
  writeln!(out, "{}", cnt).unwrap();
}
