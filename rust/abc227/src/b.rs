use proconio::input;
use std::collections::HashSet;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, s: [usize; n]}

  let mut hs: HashSet<usize> = HashSet::new();
  for i in 1..1001 {
    for j in 1..1001 {
      let p = 4 * i * j + 3 * i + 3 * j;
      if p <= 1000 {
        hs.insert(p);
      }
    }
  }
  let filtered: Vec<usize> = s.iter().filter(|i| hs.contains(&i)).map(|p| *p).collect();

  writeln!(out, "{}", n - filtered.len()).unwrap();
}
