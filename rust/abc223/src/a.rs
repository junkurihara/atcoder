use proconio::input;

pub fn a_main() {
  input! {
    x: isize
  }
  assert!(x >= 0 && x <= 1000);

  if x > 0 && x % 100 == 0 {
    println!("Yes");
  } else {
    println!("No");
  }
}
