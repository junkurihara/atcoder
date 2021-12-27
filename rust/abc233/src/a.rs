use proconio::input;
// use proconio::marker::Chars;
// use itertools::Itertools;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {x: usize, y: usize}

  if x < y {
    let modu = (y - x) % 10;
    writeln!(
      out,
      "{}",
      (y - x - modu) / 10 + if modu > 0 { 1 } else { 0 },
    )
    .unwrap();
    return;
  }
  writeln!(out, "0").unwrap();
}
