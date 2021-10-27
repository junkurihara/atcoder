use itertools::Itertools;
use proconio::input;
use std::collections::HashSet;

pub fn vec_to_int(char_n: Vec<usize>) -> usize {
  let x = char_n
    .into_iter()
    .enumerate()
    .fold(0, |acc, p| acc + (p.1 as u32) * 10u32.pow(p.0 as u32));
  x as usize
}

pub fn c_main() {
  input! {
    n: String
  }
  let char_n: Vec<char> = n.chars().collect();
  let vec_n: Vec<usize> = char_n
    .iter()
    .map(|x| (x.to_digit(10).unwrap() as usize))
    .collect();
  let idx_all_hs: HashSet<usize> = (0..char_n.len()).collect();

  let mut max = 0;
  for i in 1..char_n.len() {
    for idx_comb in (0..char_n.len()).combinations(i) {
      let idx_comb_hs: HashSet<usize> = idx_comb.iter().cloned().collect();
      let idx_diff: Vec<usize> = idx_all_hs.difference(&idx_comb_hs).map(|x| *x).collect();
      let mut val_comb: Vec<usize> = idx_comb.iter().cloned().map(|idx| vec_n[idx]).collect();
      let mut val_diff: Vec<usize> = idx_diff.iter().cloned().map(|idx| vec_n[idx]).collect();
      val_comb.sort();
      val_diff.sort();
      let prod: usize = vec_to_int(val_comb) * vec_to_int(val_diff);
      if prod > max {
        max = prod;
      }
    }
  }
  println!("{:?}", max);
}
