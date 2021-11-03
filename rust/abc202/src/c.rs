use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, a: [usize; n], b: [usize; n], c: [usize; n]}

  let mut a_cnt: HashMap<usize, usize> = HashMap::new();
  let mut bc_cnt: HashMap<usize, usize> = HashMap::new();
  for i in 0..n {
    *a_cnt.entry(a[i]).or_insert(0) += 1;
    let b_cj = b[c[i] - 1];
    *bc_cnt.entry(b_cj).or_insert(0) += 1;
  }

  let mut sum = 0;
  for (v, cnt) in a_cnt {
    sum += cnt * (*bc_cnt.get(&v).unwrap_or(&0));
  }

  writeln!(out, "{}", sum).unwrap();
}
