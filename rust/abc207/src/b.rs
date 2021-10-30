use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {a: i32, b: i32, c: i32, d: i32}
  // y = a + bx
  // y = cdx
  // cdx - bx = a
  // x = a / (cd - b)

  if c * d - b <= 0 {
    writeln!(out, "-1").unwrap();
    return;
  }

  let r = a % (c * d - b);
  let f = (a - r) / (c * d - b);
  if r > 0 {
    writeln!(out, "{}", f + 1).unwrap();
  } else {
    writeln!(out, "{}", f).unwrap();
  }
}
