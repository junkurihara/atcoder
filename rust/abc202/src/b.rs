use proconio::input;
use proconio::marker::Chars;
use std::collections::HashMap;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  let lookup: HashMap<char, char> =
    vec![('0', '0'), ('1', '1'), ('6', '9'), ('8', '8'), ('9', '6')]
      .into_iter()
      .collect();

  input! {s: Chars}
  let mut reversed: Vec<char> = s.iter().map(|x| *lookup.get(x).unwrap()).collect();
  reversed.reverse();

  writeln!(out, "{}", reversed.iter().collect::<String>()).unwrap();
}
