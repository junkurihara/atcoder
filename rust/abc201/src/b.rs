use proconio::input;
use std::collections::{BinaryHeap, HashMap};
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, mt: [(String, usize); n]}
  let mut mt_bh: BinaryHeap<usize> = mt.iter().map(|(_, height)| *height).collect();
  let mt_names: HashMap<usize, String> = mt
    .into_iter()
    .map(|(name, height)| (height, name))
    .collect();
  mt_bh.pop();
  let next = mt_bh.pop().unwrap();
  writeln!(out, "{}", mt_names.get(&next).unwrap()).unwrap();
}
