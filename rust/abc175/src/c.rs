use proconio::input;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {x: isize, k: usize, d: usize};

  let abs_x: usize = x.abs() as usize;
  let moved_distance = abs_x - abs_x % d;
  let moved_times = moved_distance / d;
  if moved_times >= k {
    writeln!(out, "{}", abs_x - k * d).unwrap();
    return;
  }
  if (k - moved_times) % 2 == 0 {
    writeln!(out, "{}", abs_x - moved_distance).unwrap();
    return;
  }
  writeln!(
    out,
    "{}",
    ((abs_x - moved_distance) as isize - d as isize).abs()
  )
  .unwrap();
}
