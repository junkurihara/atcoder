use proconio::input;
use std::process::exit;

pub fn main() {
  // (i-1) * 7 + j for original (i,j) of A
  input! {n: u32, m: u32, b: [[i64; m]; n]}

  let base_j = (b[0][0] - 1) % 7;
  let base_i = (b[0][0] - base_j) / 7;
  if m as i64 + base_j > 7 {
    println!("No");
    exit(0);
  }

  for (i, row) in b.iter().enumerate() {
    for (j, elem) in row.iter().enumerate() {
      let expect = (base_i + i as i64) * 7 + base_j + j as i64 + 1;
      if expect != *elem {
        println!("No");
        exit(0);
      }
    }
  }
  println!("Yes");
}
