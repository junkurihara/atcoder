use itertools::Itertools;
use proconio::input;
// use std::collections::HashSet;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! { s: [String; 4] }

  let un: Vec<&String> = s.iter().unique().collect();
  if un.len() < 4 {
    writeln!(out, "No").unwrap();
  } else {
    writeln!(out, "Yes").unwrap();
  }
}
