use proconio::input;
// use proconio::marker::Chars;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, ab: [(u32, u32); n-1]}
  let mut hm: HashMap<u32, Vec<u32>> = HashMap::with_capacity(n as usize);

  for (a, b) in ab {
    hm.entry(a).or_insert(Vec::new()).push(b);
    hm.entry(b).or_insert(Vec::new()).push(a);
  }
  if hm
    .iter()
    .all(|(_, v)| v.len() == 1 || v.len() == (n as usize) - 1)
  {
    writeln!(out, "Yes");
  } else {
    writeln!(out, "No");
  }
}
