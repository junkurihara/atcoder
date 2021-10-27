use proconio::input;
// use std::cmp::Reverse;
// use std::collections::{HashMap, HashSet};
// use std::process::exit;

pub fn b_main() {
  input! {
    s: String,
  }
  assert!(s.len() >= 1 && s.len() <= 1000);

  let vec_s: Vec<char> = s.chars().collect();

  let mut rotations: Vec<String> = Vec::new();
  for i in 0..s.len() {
    let mut sliced = Vec::new();
    for j in i..s.len() {
      sliced.push(vec_s[j]);
    }
    for j in 0..i {
      sliced.push(vec_s[j]);
    }
    rotations.push(sliced.into_iter().collect());
  }
  rotations.sort();
  println!("{}", rotations[0]);
  println!("{}", rotations[s.len() - 1]);
}
