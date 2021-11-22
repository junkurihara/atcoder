use proconio::input;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  let len = 1048576;
  input! {q: usize};
  input! {tx: [(isize, isize); q]};
  let mut hm: HashMap<isize, isize> = HashMap::new();

  for p in tx {
    if p.0 == 1 {
      let mut h = p.1;
      while hm.contains_key(&(h % len)) {
        h += 1;
      }
      hm.insert(h % len, p.1);
    } else {
      writeln!(out, "{}", hm.entry(p.1 % len).or_insert(-1)).unwrap();
    }
  }
}
