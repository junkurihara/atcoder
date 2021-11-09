use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {x: String}
  let int_num: Vec<&str> = x.split(".").collect();
  writeln!(out, "{}", int_num[0]).unwrap();
}
