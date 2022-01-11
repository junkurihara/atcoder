// use itertools::Itertools;
use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {k: usize}
  let s = recursive(k, "".to_string());
  writeln!(out, "{}", s).unwrap();
}

pub fn recursive(new_k: usize, com: String) -> String {
  if new_k == 0 {
    return com;
  }
  let r = new_k % 2;
  if r == 0 {
    return recursive(new_k / 2, format!("0{}", com));
  } else {
    return recursive(new_k / 2, format!("2{}", com));
  }
}
