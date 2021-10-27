use proconio::input;

pub fn vec_k_to_digits(vec_k: Vec<u64>, k: u64) -> u64 {
  vec_k
    .iter()
    .enumerate()
    .fold(0, |acc, p| acc + p.1 * k.pow(p.0 as u32))
}

pub fn b_main() {
  input! {
    k: u64
  }
  input! {
    a: String,
    b: String
  }

  let vec_a: Vec<_> = a.chars().collect();
  let mut vec_a_num: Vec<u64> = vec_a
    .iter()
    .map(|x| x.to_digit(10).unwrap() as u64)
    .collect();
  vec_a_num.reverse();
  let vec_b: Vec<_> = b.chars().collect();
  let mut vec_b_num: Vec<u64> = vec_b
    .iter()
    .map(|x| x.to_digit(10).unwrap() as u64)
    .collect();
  vec_b_num.reverse();
  println!(
    "{}",
    vec_k_to_digits(vec_a_num, k) * vec_k_to_digits(vec_b_num, k)
  );
}
