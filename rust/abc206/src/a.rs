use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: u16}

  let price: u16 = ((1.08f32 * (n as f32)).floor()) as u16;
  writeln!(
    out,
    "{}",
    if price < 206u16 {
      "Yay!"
    } else if price == 206u16 {
      "so-so"
    } else {
      ":("
    }
  )
  .unwrap();
}
