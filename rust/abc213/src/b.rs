use proconio::input;

pub fn main() {
  input! {n: usize, a: [usize; n]}
  let mut vect_idxed: Vec<(usize, usize)> = a.into_iter().enumerate().collect();
  vect_idxed.sort_by_key(|(_, p)| *p);
  println!("{}", vect_idxed[n - 2].0 + 1);
}
