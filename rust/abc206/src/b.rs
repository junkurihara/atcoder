use proconio::input;
// use proconio::marker::Chars;
// use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u64}
  // total = i(i+1)/2
  // min { i: i(i+1) >= 2n }
  // i.pow(2)+1-2n >= 0
  // i = (-1 + sqrt(1+8n))/2
  let ans: f64 = (-1.0 + (1.0f64 + 8.0 * n as f64).sqrt()) / 2.0;
  writeln!(out, "{}", ans.ceil() as u64).unwrap();
}
