use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, a: u32, x: u32, y: u32}

  if n > a {
    writeln!(out, "{}", x * a + y * (n - a)).unwrap();
  } else {
    writeln!(out, "{}", x * n).unwrap();
  }
}
