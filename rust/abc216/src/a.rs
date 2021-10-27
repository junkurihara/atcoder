use proconio::input;

pub fn a_main() {
  input! {s: String}
  let vec_s: Vec<&str> = s.split(".").collect();
  let y: u32 = vec_s[1].to_string().parse().unwrap();
  if y < 3 {
    println!("{}-", vec_s[0]);
  } else if y < 7 {
    println!("{}", vec_s[0]);
  } else {
    println!("{}+", vec_s[0]);
  }
}
