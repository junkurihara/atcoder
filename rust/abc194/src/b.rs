use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, a: [i64; n]}
  let mut counter: HashMap<u64, u64> = HashMap::new();
  for i in 0..n {
    for j in 0..i {
      let x = (a[i] - a[j]).abs();
      *counter.entry(x as u64).or_insert(0) += 1;
    }
  }
  let mut sum = 0;
  for key in counter.keys() {
    let val = counter.get(key).unwrap();
    sum += key.pow(2) * val;
  }
  writeln!(out, "{}", sum).unwrap();
}
