use proconio::input;

pub fn a_main() {
  input! { st: [String; 2] }
  let minim: &str = st.iter().min().unwrap();
  if minim == &st[0] {
    println!("Yes");
  } else {
    println!("No");
  }
}
