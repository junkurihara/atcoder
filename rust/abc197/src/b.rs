use proconio::input;
use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {h: usize, w: usize, _x: usize, _y: usize}
  input! {s: [Chars; h]}

  let x = _x - 1;
  let y = _y - 1;

  let row: Vec<char> = s[x].clone();
  let col: Vec<char> = s.into_iter().map(|v| v[y]).collect();

  let mut cnt = 0;
  for i in 1..h {
    if i + x < h && col[i + x] == '.' {
      cnt += 1;
    } else {
      break;
    }
  }

  for i in 1..h {
    if x >= i && col[x - i] == '.' {
      cnt += 1;
    } else {
      break;
    }
  }

  for i in 1..w {
    if i + y < w && row[i + y] == '.' {
      cnt += 1;
    } else {
      break;
    }
  }

  for i in 1..w {
    if y >= i && row[y - i] == '.' {
      cnt += 1;
    } else {
      break;
    }
  }

  if col[x] == '.' {
    cnt += 1;
  }
  writeln!(out, "{}", cnt).unwrap();
}
