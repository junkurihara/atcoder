use proconio::input;
// use proconio::marker::Chars;
use itertools::Itertools;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, m: usize}
  input! {ab: [(usize, usize);m]}
  input! {cd: [(usize, usize);m]}

  let mut x: Vec<Vec<bool>> = (0..n)
    .map(|_| (0..n).map(|_| false).collect::<Vec<bool>>())
    .collect();
  let mut y: Vec<Vec<bool>> = x.clone();

  for elem in ab {
    (x[elem.0 - 1])[elem.1 - 1] = true;
    (x[elem.1 - 1])[elem.0 - 1] = true;
  }
  for elem in cd {
    (y[elem.0 - 1])[elem.1 - 1] = true;
    (y[elem.1 - 1])[elem.0 - 1] = true;
  }

  // writeln!(out, "{:?}", x).unwrap();
  // writeln!(out, "{:?}", y).unwrap();

  let perm = (0..n).permutations(n);
  let mut ans = false;
  for p in perm {
    let mut ok = true;
    for i in 0..n {
      for j in 0..n {
        if x[i][j] != y[p[i]][p[j]] {
          ok = false;
        }
      }
    }
    if ok {
      ans = true;
    }
  }
  if ans {
    writeln!(out, "Yes").unwrap();
  } else {
    writeln!(out, "No").unwrap();
  }
}
