use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize}
  let mut nmut = n;

  for _ in 0..9 {
    if nmut % 10 != 0 || nmut == 0 {
      break;
    }
    nmut /= 10;
  }

  let vect: Vec<char> = nmut.to_string().chars().collect();
  let mut rev = vect.clone();
  rev.reverse();

  if rev.iter().collect::<String>() == vect.iter().collect::<String>() {
    writeln!(out, "Yes").unwrap();
  } else {
    writeln!(out, "No").unwrap();
  }
}
