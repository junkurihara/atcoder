use proconio::input;
use std::collections::HashSet;

pub fn b_main() {
  input! {n: usize, names: [[String; 2]; n]}
  let veclen = names.len();
  let hs: HashSet<String> = names
    .into_iter()
    .map(|p| format!("{}_{}", p[0], p[1]).to_string())
    .collect();
  let hslen = hs.len();
  if veclen > hslen {
    println!("Yes");
  } else {
    println!("No");
  }
}
