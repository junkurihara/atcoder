use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, s: Chars, q: usize}
  input! {queries: [(usize, usize, usize); q]}
  let mut ss: Vec<Vec<char>> = Vec::new();
  ss.push(
    s.iter()
      .enumerate()
      .filter(|(i, _)| *i < n)
      .map(|(_, x)| *x)
      .collect(),
  );
  ss.push(
    s.iter()
      .enumerate()
      .filter(|(i, _)| *i >= n)
      .map(|(_, x)| *x)
      .collect(),
  );

  let mut cnt = 0;
  for query in queries {
    if query.0 == 1 {
      let a_res = (query.1 - 1) % n;
      let a_f_or_r = ((query.1 - 1) - a_res) / n;
      let b_res = (query.2 - 1) % n;
      let b_f_or_r = ((query.2 - 1) - b_res) / n;

      let tmp = ss[(a_f_or_r + cnt) % 2][(query.1 - 1) % n];
      ss[(a_f_or_r + cnt) % 2][(query.1 - 1) % n] = ss[(b_f_or_r + cnt) % 2][(query.2 - 1) % n];
      ss[(b_f_or_r + cnt) % 2][(query.2 - 1) % n] = tmp;
    } else {
      cnt += 1;
    }
  }
  let mut stringified: Vec<String> = ss
    .into_iter()
    .map(|x| x.iter().collect::<String>())
    .collect();
  if cnt % 2 == 0 {
    writeln!(out, "{}", stringified.into_iter().collect::<String>()).unwrap();
  } else {
    let tmp = stringified[0].clone();
    stringified[0] = stringified[1].clone();
    stringified[1] = tmp;
    writeln!(out, "{}", stringified.into_iter().collect::<String>()).unwrap();
  }
}
