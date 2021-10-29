use proconio::input;
use proconio::marker::Chars;

pub fn main() {
  input! {x: Chars}
  let xnum: Vec<usize> = x
    .iter()
    .map(|c| (*c).to_string().parse::<usize>().unwrap())
    .collect();
  let xnum_slice: &[usize] = &xnum[0..3];

  if xnum.iter().all(|y| *y == xnum[0])
    || xnum_slice
      .iter()
      .enumerate()
      .all(|(i, c)| xnum[i + 1] == (*c + 1) % 10)
  {
    println!("Weak");
  } else {
    println!("Strong");
  }
}
