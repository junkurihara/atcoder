use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: Chars}

  let length = (n.len() - (n.len() % 2)) / 2;
  if n.len() % 2 == 1 {
    writeln!(out, "{}", 10u32.pow(length as u32) - 1).unwrap();
  } else {
    let former: u32 = (&n[0..length])
      .iter()
      .collect::<String>()
      .parse::<u32>()
      .unwrap();
    let latter: u32 = (&n[length..n.len()])
      .iter()
      .collect::<String>()
      .parse::<u32>()
      .unwrap();
    if former > latter {
      writeln!(out, "{}", former - 1).unwrap();
    } else {
      writeln!(out, "{}", former).unwrap();
    }
  }
}
