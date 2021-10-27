use proconio::input;
use std::collections::HashMap;

pub fn c_main() {
  input! { n: usize, vec_p: [usize; n]}
  let hs_p: HashMap<usize, usize> = vec_p.iter().enumerate().map(|(i, p)| (*p, i + 1)).collect();
  for i in 0..n {
    print!("{} ", hs_p.get(&(i + 1)).unwrap());
  }
  println!();
}
