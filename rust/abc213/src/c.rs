// use itertools::Itertools;
use proconio::input;
use std::collections::{HashMap, HashSet};

pub fn main() {
  input! {
    _h: usize,
    _w: usize,
    n: usize,
    ab: [[usize; 2]; n]
  }

  let mut non_null_rows: Vec<usize> = ab.clone().iter().map(|v| v[0]).collect();
  non_null_rows.sort();
  non_null_rows.dedup();
  let mut non_null_cols: Vec<usize> = ab.clone().iter().map(|v| v[1]).collect();
  non_null_cols.sort();
  non_null_cols.dedup();

  let row_mapper: HashMap<usize, usize> = non_null_rows
    .iter()
    .enumerate()
    .map(|(vec_idx, idx)| (*idx, vec_idx + 1))
    .collect();
  let col_mapper: HashMap<usize, usize> = non_null_cols
    .iter()
    .enumerate()
    .map(|(vec_idx, idx)| (*idx, vec_idx + 1))
    .collect();

  for point in ab {
    println!(
      "{} {}",
      row_mapper.get(&point[0]).unwrap(),
      col_mapper.get(&point[1]).unwrap()
    );
  }
}
