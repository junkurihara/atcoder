use proconio::input;
use std::collections::HashMap;

pub fn c_main() {
  input! {x: String}
  input! {n: usize}
  let mut names: Vec<String> = Vec::new();
  for _ in 0..n {
    input! { w: String}
    names.push(w);
  }

  let x_chars: Vec<char> = x.chars().collect();
  let mut ord_dict: HashMap<char, u32> = HashMap::new();
  for (i, p) in x_chars.iter().enumerate() {
    ord_dict.insert(*p, i as u32);
  }

  let mut mapped_names: Vec<(Vec<u32>, String)> = Vec::new();
  for p in names {
    let p_char: Vec<char> = p.chars().collect();
    let mapped_code: Vec<u32> = p_char.iter().map(|c| *ord_dict.get(c).unwrap()).collect();
    mapped_names.push((mapped_code, p));
  }
  // println!("{:#?}", mapped_names);
  mapped_names.sort_by_key(|key| key.0.clone());

  for p in mapped_names {
    println!("{}", p.1);
  }
}
