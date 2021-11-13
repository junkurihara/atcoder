use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize}
  let mut sum = 0;

  let a_max_sqrt = (n as f64).sqrt().floor() as usize;

  for a in 1..a_max_sqrt + 1 {
    let b_max = (n - (n % a)) / a;
    let b_max_sqrt = (b_max as f64).sqrt().floor() as usize;

    // if b_max_sqrt >= a {
    //   println!("{}, {}", a, (b_max - (b_max % a)) / a);
    //   sum += (b_max - (b_max % a)) / a;
    // }
    if b_max_sqrt >= a {
      // b_min ~ b_maxで整数組はいくつあるか
      for b in a..b_max_sqrt + 1 {
        let c_max = (n - (n % (a * b))) / (a * b);
        if c_max >= b {
          sum += c_max - b + 1;
        }
      }
    }
  }

  writeln!(out, "{}", sum).unwrap();
}
