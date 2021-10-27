use proconio::input;

pub fn b_main() {
  let mut words: Vec<String> = Vec::new();
  for _ in 0..3 {
    input! {
      s: String
    }
    words.push(s);
  }
  input! {
    t: String
  }
  let pattern: Vec<char> = t.chars().collect();
  let mapped = pattern
    .into_iter()
    .map(|x| {
      let int_x = x.to_digit(10).unwrap();
      words[(int_x as usize) - 1].clone()
    })
    .collect::<Vec<_>>()
    .join("");
  println!("{}", mapped);
  // let joined: &String = mapped.join(" ");
}
