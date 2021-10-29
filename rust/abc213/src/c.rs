// use itertools::Itertools;
use proconio::input;
// use std::collections::{HashMap, HashSet};

pub fn main() {
  input! {
    _h: u32,
    _w: u32,
    n: usize,
    ab: [[u32; 2]; n]
  }

  let mut newab: Vec<(u32, u32, usize)> = ab
    .iter()
    .enumerate()
    .map(|(i, p)| (p[0], p[1], i))
    .collect();

  let mut newab2: Vec<(u32, u32, usize)> = Vec::with_capacity(n);
  newab.sort_by_key(|p| p.0);
  let mut new_idx = 1;
  let mut local = newab[0].0;
  for mut p in newab {
    if p.0 != local {
      local = p.0;
      new_idx += 1;
    }
    p.0 = new_idx;
    newab2.push(p);
  }

  let mut newab3: Vec<(u32, u32, usize)> = Vec::with_capacity(n);
  newab2.sort_by_key(|p| p.1);
  let mut new_idx = 1;
  let mut local = newab2[0].1;
  for mut p in newab2 {
    if p.1 != local {
      local = p.1;
      new_idx += 1;
    }
    p.1 = new_idx;
    newab3.push(p);
  }

  newab3.sort_by_key(|p| p.2);

  for p in newab3 {
    println!("{} {}", p.0, p.1);
  }
}
