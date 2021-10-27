use proconio::input;
use std::collections::HashMap;

const ALPHABET: &str = "abcdefghijklmnopqrstuvwxyz";

fn get_alphabet_hs() -> HashMap<u32, char> {
  let mut chars_hs: HashMap<u32, char> = HashMap::new();
  let chars: Vec<char> = ALPHABET.chars().collect();
  for (i, c) in chars.into_iter().enumerate() {
    chars_hs.insert(i as u32, c);
  }
  return chars_hs;
}

pub fn b_main() {
  let chars_hs = get_alphabet_hs();
  input! {p: [u32; 26]}
  let s: Vec<_> = p
    .into_iter()
    .map(|x| chars_hs.get(&(x - 1)).unwrap())
    .collect();
  let ss: String = s.into_iter().collect();
  println!("{}", ss);
}
