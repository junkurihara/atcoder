use proconio::input;

pub fn a_main() {
  input!{
    s: String
  }
  assert!(s.len() >= 2 && s.len() <= 20);

  if &s[s.len()-2..] == "er" {
    println!("er");
  }
  else {
    println!("ist");
  }

}
