use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, a: [u32; n]}

  let num = a.iter().fold(0, |acc, x| acc + *x - (*x).min(10));

  writeln!(out, "{}", num);
}
