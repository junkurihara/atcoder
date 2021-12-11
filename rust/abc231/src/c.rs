use proconio::input;
// use proconio::marker::Chars;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, q: usize}
  input! {a: [usize; n]}
  input! {xs: [usize; q]}
  let mut sorted_a: Vec<usize> = a.clone();
  let mut sorted_xs: Vec<usize> = xs.clone();
  sorted_a.sort();
  sorted_xs.sort();
  let mut hm: HashMap<usize, usize> = HashMap::new();

  let mut ptr = 0;
  for x in sorted_xs {
    for i in ptr..n {
      if x <= *sorted_a.get(i).unwrap() {
        ptr = i;
        break;
      } else if i == n - 1 {
        ptr = n;
      }
    }
    if ptr == n {
      hm.entry(x).or_insert(0);
    } else {
      hm.entry(x).or_insert(n - ptr);
    }
  }
  for x in xs {
    writeln!(out, "{}", hm.get(&x).unwrap()).unwrap();
  }
}
