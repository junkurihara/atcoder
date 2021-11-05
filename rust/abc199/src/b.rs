use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, a: [u32; n], b: [u32; n]}

  let max_a = a.iter().max().unwrap();
  let min_b = b.iter().min().unwrap();


  if max_a > min_b {
    writeln!(out, "0").unwrap();
  } else {
    writeln!(out, "{}", *min_b - *max_a + 1).unwrap();
  }

}
