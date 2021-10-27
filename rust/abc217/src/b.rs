use proconio::input;
use std::collections::HashSet;

pub fn b_main() {
  let hs_contest: HashSet<String> = vec![
    "ABC".to_string(),
    "ARC".to_string(),
    "AGC".to_string(),
    "AHC".to_string(),
  ]
  .into_iter()
  .collect();
  input! { s123: [String; 3] }
  let hs_s123 = s123.into_iter().collect::<HashSet<String>>();
  let diff: HashSet<_> = hs_contest.difference(&hs_s123).collect();
  println!("{}", diff.iter().next().unwrap());
}
