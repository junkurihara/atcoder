// use itertools::Itertools;
use proconio::input;

pub fn main() {
  input! {
    n: usize, m: usize,
    mut a_mut: [i32; n],
    mut b_mut: [i32; m]
  }
  a_mut.sort();
  b_mut.sort();
  // println!("{:?}", a_mut);
  // println!("{:?}", b_mut);
  let mut a_ptr = 0;
  let mut b_ptr = 0;
  let mut min_abs = 10i32.pow(9);
  for _ in 0..n + m {
    let abs = (a_mut[a_ptr] - b_mut[b_ptr]).abs();
    if min_abs > abs {
      min_abs = abs;
    }
    if a_mut[a_ptr] <= b_mut[b_ptr] && a_ptr < n - 1 {
      a_ptr += 1;
    } else if a_mut[a_ptr] > b_mut[b_ptr] && b_ptr < m - 1 {
      b_ptr += 1;
    } else {
      break;
    }
  }
  println!("{}", min_abs);
}
