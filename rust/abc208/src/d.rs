use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! { n: usize, m: usize, abc: [(usize, usize, usize); m]}
  let mut hm: HashMap<usize, Vec<(usize, usize)>> = HashMap::new();

  for p in abc {
    hm.entry(p.0).or_insert(Vec::new()).push((p.1, p.2));
  }
  for x in hm {
    println!("{:?}", x);
  }

  writeln!(out, "{}", 0).unwrap();
}
