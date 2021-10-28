use proconio::input;

pub fn main() {
  input! {n: usize}
  let max = 60;
  let mut pow = 0;
  let mut next = n;
  for _ in 0..max {
    if next == 1 {
      println!("{}", pow);
      break;
    } else {
      next = (next - (next % 2)) / 2;
      pow += 1;
    }
  }
}
