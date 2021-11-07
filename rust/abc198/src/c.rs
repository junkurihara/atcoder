use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {r: usize, x: usize, y: usize}

  let distance = ((x.pow(2) + y.pow(2)) as f64).sqrt();
  let x = (distance / (r as f64)).floor();
  println!("{} {}", distance, distance % (r as f64));
  let steps = if distance % (r as f64) == 0f64 {
    x
  } else {
    x + 1.0f64
  };
  writeln!(out, "{}", steps);
}
