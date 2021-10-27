use proconio::input;

pub fn a_main() {
  input! {
    x: u32
  }
  if x < 40 {
    println!("{}", 40 - x);
  } else if x < 70 {
    println!("{}", 70 - x);
  } else if x < 90 {
    println!("{}", 90 - x);
  } else {
    println!("expert");
  }
}
