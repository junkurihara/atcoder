use proconio::input;
// use proconio::marker::Chars;
// use std::collections::VecDeque;
use std::cmp::Reverse;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, k: usize, a: [usize; n]}
  // choose members from teams as large as possible
  let mut vect: Vec<usize> = a.into_iter().collect();
  let mut cnt = 0;
  while vect.len() >= k {
    vect.sort_by_key(|&x| Reverse(x));
    let l = vect.pop().unwrap();
    cnt += l;
    for i in 0..k - 1 {
      vect[i] -= l;
    }
  }
  writeln!(out, "{}", cnt).unwrap();
}
