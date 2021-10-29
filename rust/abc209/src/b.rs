use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, x: u32, a: [u32; n]}

  let sum: u32 = a.iter().enumerate().fold(
    0,
    |acc, (i, v)| {
      if i % 2 == 0 {
        acc + v
      } else {
        acc + v - 1
      }
    },
  );
  if sum <= x {
    writeln!(out, "Yes");
  } else {
    writeln!(out, "No");
  }
}
