use proconio::input;
use proconio::marker::Chars;
use std::collections::HashSet;

use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {s: Chars}
  let inc_hs: HashSet<usize> = s
    .iter()
    .enumerate()
    .filter(|(_, x)| **x == 'o')
    .map(|(i, _)| i)
    .collect();
  let notinc_hs: HashSet<usize> = s
    .iter()
    .enumerate()
    .filter(|(_, x)| **x == 'x')
    .map(|(i, _)| i)
    .collect();

  let mut cnt = 0;
  for idx in 0..10000 {
    let str_idx = format!("{:04}", idx);
    let hs: HashSet<usize> = str_idx
      .chars()
      .map(|c| c.to_digit(10).unwrap() as usize)
      .collect();
    let inc_len = hs.intersection(&inc_hs).collect::<HashSet<&usize>>().len();
    let notinc_len = hs
      .intersection(&notinc_hs)
      .collect::<HashSet<&usize>>()
      .len();
    if inc_len == inc_hs.len() && notinc_len == 0 {
      cnt += 1;
    }
  }
  writeln!(out, "{}", cnt).unwrap();
}
