use proconio::input;
// use proconio::marker::Chars;
use std::collections::{HashMap, HashSet};
use std::io::{stdout, BufWriter, Write};
pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, m: usize}
  input! {ab: [(usize, usize); m]}

  let mut hm1: HashMap<usize, Vec<usize>> = HashMap::new();
  let mut hm2: HashMap<usize, Vec<usize>> = HashMap::new();

  for (ai, bi) in ab {
    hm1.entry(ai).or_insert(Vec::new()).push(bi);
    hm1.entry(bi).or_insert(Vec::new()).push(ai);
    let vecai = hm1.get(&ai).unwrap();
    let vecbi = hm1.get(&bi).unwrap();
    if vecai.len() > 2 || vecbi.len() > 2 {
      writeln!(out, "No").unwrap();
      return;
    }
  }

  writeln!(out, "Yes").unwrap();

  // 1 -> 2
  // 2 -> 3
  // 3 -> 1
  // loop detection
  // or
  // detection of a node connected with more than 2 nodes

  // writeln!(out, "{}", d / 100.0).unwrap();
}
