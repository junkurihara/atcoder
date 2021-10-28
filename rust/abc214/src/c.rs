use proconio::input;

pub fn main() {
  input! {
    n: usize,
    s: [usize; n],
    t: [usize; n],
  }
  let start_point = t
    .clone()
    .into_iter()
    .enumerate()
    .min_by_key(|(_, b)| *b)
    .unwrap();
  let mut vect: Vec<usize> = vec![0; n];
  vect[start_point.0] = start_point.1;

  let start_idx = start_point.0;
  for i in 1..n {
    let next_idx = (start_idx + i) % n;
    let prev_idx = (start_idx + i - 1) % n;
    let next_time = t[next_idx].min(vect[prev_idx] + s[prev_idx]);
    vect[next_idx] = next_time;
  }

  for i in 0..n {
    println!("{}", vect[i]);
  }
}
