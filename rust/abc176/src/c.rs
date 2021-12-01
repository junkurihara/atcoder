use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize};
  input! {a: [usize; n]}

  let mut sum = 0;
  let mut ptr = 0;
  let mut ptr_v = a.get(ptr).unwrap();
  for (i, v) in a.iter().enumerate() {
    if v >= ptr_v {
      ptr = i;
      ptr_v = a.get(ptr).unwrap();
    } else {
      sum += ptr_v - v;
    }
  }

  writeln!(out, "{}", sum).unwrap();
}
