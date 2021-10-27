use proconio::input;

pub fn a_main() {
  input! { n: usize}
  input! { s: String}
  let vec_s: Vec<char> = s.chars().collect();
  if vec_s[n - 1] == 'o' {
    println!("Yes");
  } else {
    println!("No");
  }
}
