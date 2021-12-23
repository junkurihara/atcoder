use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {s: Chars}
  input! {t: Chars}

  let s_int: Vec<u32> = s.iter().map(|c| c.to_digit(36).unwrap() - 10).collect();
  let s_norm = normalize(&s_int);
  let t_int: Vec<u32> = t.iter().map(|c| c.to_digit(36).unwrap() - 10).collect();
  let t_norm = normalize(&t_int);

  if s_norm
    .into_iter()
    .enumerate()
    .all(|(idx, v)| v == *t_norm.get(idx).unwrap())
  {
    writeln!(out, "Yes").unwrap();
  } else {
    writeln!(out, "No").unwrap();
  }
}

fn normalize(seq: &[u32]) -> Vec<u32> {
  let top = seq[0];
  seq.iter().map(|u| (26 + u - top) % 26).collect()
}
