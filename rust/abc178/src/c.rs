use proconio::input;
use std::io::{stdout, BufWriter, Write};

const div: isize = 1_000_000_000 + 7;

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize};

  let not_0 = (1..n + 1).fold(1, |prod, _| (prod * 9) % div);
  let not_9 = not_0.clone();
  let intersection_not_09 = (1..n + 1).fold(1, |prod, _| (prod * 8) % div);
  let any_case = (1..n + 1).fold(1, |prod, _| (prod * 10) % div);
  // println!("{} {} {} {}", not_0, not_9, intersection_not_09, any_case);
  let true_set = (div + (any_case - (not_0 + not_9 - intersection_not_09)) % div) % div;
  writeln!(out, "{}", true_set).unwrap();
}
