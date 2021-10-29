use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

const CHOKUDAI: &str = "chokudai";
const DIV: u32 = 10u32.pow(9) + 7;

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {s: Chars}

  writeln!(out, "{}", 0).unwrap();
}
