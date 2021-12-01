use proconio::input;
use std::collections::VecDeque;
use std::io::{stdout, BufWriter, Write};

const div: usize = 1_000_000_000 + 7;

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize};
  input! {a: [usize; n]}

  let mut acc: VecDeque<usize> = VecDeque::new();
  for idx in (0..n).rev() {
    if idx == n - 1 {
      acc.push_front(0);
    } else {
      let val = &acc.get(0).unwrap();
      acc.push_front((**val + a.get(idx + 1).unwrap()) % div);
    }
  }

  let sum: usize = acc
    .iter()
    .enumerate()
    .fold(0, |acc, x| (acc + (x.1 * a.get(x.0).unwrap()) % div) % div);
  writeln!(out, "{}", sum % div).unwrap();
}
