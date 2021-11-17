use proconio::input;

use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, x: usize};
  input! {a: [usize; n]}

  a.into_iter().for_each(|y| {
    if x != y {
      write!(out, "{} ", y).unwrap();
    }
  });
  writeln!(out, "").unwrap();
}
