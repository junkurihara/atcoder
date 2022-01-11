use proconio::input;
// use proconio::marker::Chars;
// use itertools::Itertools;
use std::cmp::Reverse;
use std::collections::BinaryHeap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, k: usize}
  input! {p: [usize; n]}
  let mut p_heap: BinaryHeap<Reverse<usize>> = BinaryHeap::new();
  (p.clone())[..k]
    .into_iter()
    .for_each(|x| p_heap.push(Reverse(*x)));

  writeln!(out, "{}", p_heap.peek().unwrap().0).unwrap();
  for i in k..n {
    let new_val = p.get(i).unwrap();
    let old_val = p_heap.peek().unwrap().0;
    if *new_val > old_val {
      p_heap.pop();
      p_heap.push(Reverse(*new_val));
      writeln!(out, "{:?}", p_heap.peek().unwrap().0).unwrap();
    } else {
      writeln!(out, "{:?}", old_val).unwrap();
    }
  }
}
