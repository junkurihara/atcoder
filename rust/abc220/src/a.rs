use proconio::input;

pub fn a_main() {
  input! {
    a: usize,
    b: usize,
    c: usize,
  }

  if b - (b % c) < a {
    println!("-1");
  } else {
    println!("{}", c * (b / c as usize));
  }
}
