use proconio;

fn main() {
  proconio::input! {
    a: u32
  }
  proconio::input! {
    b: u32,
    c: u32
  }

  proconio::input! {
    s: String
  }

  println!("{} {}", a+b+c, s)
}
