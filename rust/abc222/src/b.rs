use proconio::input;

pub fn b_main() {
  input! {
    n: usize,
    p: usize
  }

  input! {
    points: [usize; n]
  }

  let cnt = points
    .into_iter()
    .fold(0, |acc, x| if x < p { acc + 1 } else { acc });

  println!("{}", cnt);
}
