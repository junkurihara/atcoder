use proconio::input;

pub fn b_main() {
  input! {
    s: String,
  }
  input! {
    t: String,
  }

  let s_vec: Vec<char> = s.chars().collect();
  let t_vec: Vec<char> = t.chars().collect();

  let diff_vec: Vec<u32> = s_vec
    .into_iter()
    .zip(t_vec.into_iter())
    .map(|(sc, tc)| sc.to_digit(36).unwrap() ^ tc.to_digit(36).unwrap())
    .collect();
  let mut non_zero: Vec<(usize, u32)> = Vec::new();
  for (i, p) in diff_vec.iter().enumerate() {
    if *p != 0 {
      non_zero.push((i, *p));
    }
  }

  if non_zero.len() % 2 == 1 || non_zero.len() > 2 {
    println!("No");
  } else if non_zero.len() == 2 {
    if non_zero[0].1 == non_zero[1].1 && non_zero[0].0 + 1 == non_zero[1].0 {
      println!("Yes");
    } else {
      println!("No");
    }
  } else {
    println!("Yes");
  }
}
