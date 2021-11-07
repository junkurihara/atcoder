use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize}
  let mut nmut = n;

  while nmut % 10 == 0 {
    nmut /= 10;
  }
  println!("{}", nmut);
}
