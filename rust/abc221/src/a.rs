use proconio::input;

pub fn a_main() {
  input! {
    a: usize,
    b: usize
  }
  println!("{}", (32 as u32).pow((a - b) as u32));
}
