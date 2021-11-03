use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {num_a: usize, num_b: usize, k: usize}
  let total_len = num_a + num_b;
}
