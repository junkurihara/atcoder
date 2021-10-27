use proconio::input;
use std::process::exit;

pub fn b_main(){
  input! {
    h: u32,
    w: u32
  }
  assert!(h >= 2 && h <= 50 && w >= 2 && w <= 50);

  let mut vec_a: Vec<Vec<u32>> = Vec::new();
  for i in 0..h {
    input!{
      vec_b: [u32; w]
    }
    vec_a.push(vec_b)
  }

  for i_1 in 0..(h as usize)-1 {
    for i_2 in i_1+1..(h as usize) {
      for j_1 in 0..(w as usize)-1 {
        for j_2 in j_1+1..(w as usize) {
          if vec_a[i_1][j_1] + vec_a[i_2][j_2] > vec_a[i_2][j_1] + vec_a[i_1][j_2] {
            println!("No");
            exit(0);
          }
        }
      }
    }
  }

  println!("Yes");
}
