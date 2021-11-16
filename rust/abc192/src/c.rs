use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, k: usize}
  let val = (0..k).fold(n, |val, _| func(val));

  writeln!(out, "{}", val).unwrap();
}

fn func(v: usize) -> usize {
  let mut vect: Vec<usize> = v
    .to_string()
    .chars()
    .map(|c| c.to_string().parse::<usize>().unwrap())
    .collect();
  vect.sort();

  let (max, min) = vect.iter().enumerate().fold((0, 0), |acc, (idx, e)| {
    (
      acc.0 + e * 10usize.pow(idx as u32),
      acc.1 + e * 10usize.pow((vect.len() - idx - 1) as u32),
    )
  });

  max - min
}
