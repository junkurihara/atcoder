use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {a: u8, b: u8, c: u8}
  let mut vect = vec![a, b, c];
  vect.sort();

  if vect[0] == vect[1] {
    writeln!(out, "{}", vect[2]).unwrap();
  } else if vect[1] == vect[2] {
    writeln!(out, "{}", vect[0]).unwrap();
  } else {
    writeln!(out, "0").unwrap();
  }
}
