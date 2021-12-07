use itertools::Itertools;
use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize};
  input! {ls: [usize; n]};
  let mut hm: HashMap<usize, usize> = HashMap::new();
  for x in ls {
    *hm.entry(x).or_insert(0) += 1;
  }
  let combs = hm.iter().map(|(k, _)| *k).combinations(3);
  let mut num = 0;
  for c in combs {
    let mut cloned = c.clone();
    cloned.sort();
    if cloned[0] + cloned[1] > cloned[2] {
      let local_sum =
        hm.get(&cloned[0]).unwrap() * hm.get(&cloned[1]).unwrap() * hm.get(&cloned[2]).unwrap();
      num += local_sum;
    }
  }

  writeln!(out, "{:?}", num).unwrap();
}
