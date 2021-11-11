use proconio::input;
use std::collections::HashSet;
use std::io::{stdout, BufWriter, Write};

pub fn main(){
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32}
  input! {ab: [(i32, i32); n]}

  let mut hs: HashSet<(i32, i32)> = HashSet::new();
  for (i, x) in ab.iter().enumerate() {
    let slice = &ab[i+1..];
    for y in slice {
      let forward = (y.0 - x.0, y.1 - x.1);
      let reverse = (x.0 - y.0, x.1 - y.1);
      let div = if forward.0 != 0 && forward.1 != 0 {
        gcd( forward.0.abs() as u32, forward.1.abs() as u32) as i32
      } else {
        (forward.0 + forward.1).abs()
      };
      hs.insert((forward.0/div, forward.1/div));
      hs.insert((reverse.0/div, reverse.1/div));
    }
  }
  writeln!(out, "{}", hs.len()).unwrap();

}

fn gcd (a: u32, b: u32) -> u32 {
  if a % b == 0 {
    return b;
  } else {
    return gcd(b, a % b);
  }
}
