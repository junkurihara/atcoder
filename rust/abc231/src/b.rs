use proconio::input;
use std::collections::HashMap;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  let mut hm: HashMap<String, usize> = HashMap::new();
  input! {n: usize}
  input! {s: [String; n]}
  for name in s {
    *hm.entry(name).or_insert(0) += 1;
  }

  writeln!(
    out,
    "{}",
    hm.into_iter().max_by_key(|(_, val)| *val).unwrap().0
  )
  .unwrap();
}
