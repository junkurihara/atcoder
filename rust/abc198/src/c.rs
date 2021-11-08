use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {r: usize, x: usize, y: usize}

  let distance = ((x.pow(2) + y.pow(2)) as f64).sqrt();
  let steps = (distance / (r as f64)).ceil();
  println!("{} {} {}", distance, distance % (r as f64), steps);
  let total = if distance % (r as f64) == 0f64 || steps > 1f64 {
    steps
  } else {
    steps + 1.0f64
  };
  writeln!(out, "{}", total).unwrap();
}
