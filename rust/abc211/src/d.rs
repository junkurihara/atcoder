use proconio::input;
use std::cmp::Reverse;
use std::collections::BinaryHeap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  writeln!(out, "{}", 0).unwrap();
}
