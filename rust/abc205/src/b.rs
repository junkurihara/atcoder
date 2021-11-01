use proconio::input;
// use proconio::marker::Chars;
use std::collections::HashSet;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32}
  input! {a:[u32; n]}
  let hs: HashSet<u32> = a.into_iter().collect();
  if hs.len() == n as usize && hs.get(&1) != None {
    writeln!(out, "Yes").unwrap();
  } else {
    writeln!(out, "No").unwrap();
  }
}
