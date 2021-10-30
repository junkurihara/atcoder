use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, k: u32, c: [u32; n]}

  let mut candies: HashMap<u32, u32> = HashMap::new();
  for candy in &c[0..(k as usize)] {
    *candies.entry(*candy).or_insert(0) += 1
  }
  let mut max_type = candies.len();
  for idx in 0..n - k {
    *candies.entry(c[(k + idx) as usize]).or_insert(0) += 1;
    *candies.entry(c[idx as usize]).or_insert(0) -= 1;
    if *candies.get(&c[idx as usize]).unwrap() == 0 {
      candies.remove(&c[idx as usize]).unwrap();
    }

    println!("{:?}", candies);
    let c_len = candies.len();
    if max_type < c_len {
      max_type = c_len;
    }
  }
  writeln!(out, "{}", max_type);
}
