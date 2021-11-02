use proconio::input;
use std::collections::{HashMap, HashSet};
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, m: u32, ab: [(u32, u32); m]}

  // writeln!(out, "{}", cnt).unwrap();
}
