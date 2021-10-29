use proconio::input;
use std::io::{stdout, BufWriter, Write};

fn fct(m: u32) -> u32 {
  if m > 1 {
    m * fct(m - 1)
  } else {
    1
  }
}
pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {p: u32}
  let mut cnt = 0;
  let mut res = p;
  for i in (1..11).rev() {
    let f = fct(i);
    let r = res % f;
    cnt += (res - r) / f;
    res = r;
  }
  writeln!(out, "{}", cnt).unwrap()
}
