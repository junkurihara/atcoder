use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, a: [usize; n]}
  let mut hs: HashMap<usize, usize> = HashMap::with_capacity(n);
  let mut cnt = 0;
  for i in 0..n {
    let target = a[n - i - 1];
    let target_cnt = hs.entry(target).or_insert(0);
    cnt += i - *target_cnt;
    *target_cnt += 1;
  }
  writeln!(out, "{}", cnt).unwrap();
}
