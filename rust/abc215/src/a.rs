use proconio::input;

pub fn main() {
  input! {s: String}
  if s == "Hello,World!" {
    println!("AC");
  } else {
    println!("WA");
  }
}
