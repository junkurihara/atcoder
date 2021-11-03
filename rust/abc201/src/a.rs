use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {a: [u8; 3]}
  let mut a_sorted = a.clone();
  a_sorted.sort();
  if a_sorted[2] - a_sorted[1] == a_sorted[1] - a_sorted[0] {
    writeln!(out, "Yes").unwrap();
  } else {
    writeln!(out, "No").unwrap();
  }
}
