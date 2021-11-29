use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {a: Chars, b: Chars};
  let loop_len = a.len().min(b.len());
  let mut ar = a.clone();
  ar.reverse();
  let mut br = b.clone();
  br.reverse();
  for i in 0..loop_len {
    let a_u: usize = ar[i].to_string().parse().unwrap();
    let b_u: usize = br[i].to_string().parse().unwrap();
    if a_u + b_u > 9 {
      writeln!(out, "Hard").unwrap();
      return;
    }
  }
  writeln!(out, "Easy").unwrap();
}
