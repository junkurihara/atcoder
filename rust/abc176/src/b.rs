use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: Chars};
  let sum = n.into_iter().fold(0, |acc, char_s| {
    let num_s: usize = char_s.to_string().parse().unwrap();
    (acc + num_s) % 9
  });
  writeln!(out, "{}", if sum % 9 == 0 { "Yes" } else { "No" }).unwrap();
}
