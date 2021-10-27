use itertools::Itertools;
use proconio::input;
use proconio::marker::Chars;
use std::collections::HashSet;

pub fn main() {
  input! {
    s: Chars,
    k: usize
  }
  let length = s.len();

  let hs: HashSet<String> = s
    .into_iter()
    .permutations(length)
    .map(|v| v.iter().collect::<String>())
    .collect();
  let mut vec_s: Vec<String> = hs.into_iter().collect();
  vec_s.sort();
  println!("{}", vec_s[k - 1]);
}
