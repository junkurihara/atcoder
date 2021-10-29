use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  let div: u64 = 7 + 10u64.pow(9);
  input! {n: u32, c: [u64; n]}
  let mut c_clone = c.clone();
  c_clone.sort();

  let mut mul = 1;
  for (i, p) in c_clone.iter().enumerate() {
    mul *= *p - (i as u64);
    mul %= div;
  }
  writeln!(out, "{}", mul);
}
