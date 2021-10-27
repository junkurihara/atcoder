use itertools::Itertools;
use proconio::input;
use std::cmp::Reverse;
use std::process::exit;
/*
argmin_{
sum_{i in I} Ai >= X
sum_{i in I} Bi >= Y
} |I|

-1の判定は全部のsumをとってX,Y判定すればよい。

X個以上になる全てのi \subset I
Y個以上になる全てのi \subset I
のそれぞれで、
HashSet<Vec<u32>>かHashSet<HashSet<u32>>作って、
それのintersectionとって、
最小要素を見つければよい
*/
#[derive(Debug, Clone)]
struct Bento {
  idx: u32,
  a: u32,
  b: u32,
}
pub fn d_main() {
  input! {n: u32}
  input! {x: u32, y: u32}
  let mut vec_ab: Vec<Bento> = Vec::new();
  for i in 0..n {
    input! {a: u32, b: u32}
    vec_ab.push(Bento { idx: i, a, b });
  }

  // check possibility
  let (max_x, max_y) = vec_ab
    .clone()
    .iter()
    .fold((0, 0), |acc, x| (x.a + acc.0, x.b + acc.1));

  if max_x < x || max_y < y {
    println!("-1");
    exit(0);
  }

  vec_ab.sort_by_key(|bento| (Reverse(bento.a), Reverse(bento.b)));

  let mut acc = (0u32, 0u32);
  let mut num_for_a = 0;
  for (i, p) in vec_ab.iter().enumerate() {
    acc = (acc.0 + p.a, acc.1 + p.b);
    if acc.0 >= x && acc.1 >= y {
      num_for_a = i + 1;
      break;
    }
  }

  vec_ab.sort_by_key(|bento| (Reverse(bento.b), Reverse(bento.a)));

  let mut acc = (0u32, 0u32);
  let mut num_for_b = 0;
  for (i, p) in vec_ab.iter().enumerate() {
    acc = (acc.0 + p.a, acc.1 + p.b);
    if acc.0 >= x && acc.1 >= y {
      num_for_b = i + 1;
      break;
    }
  }

  println!("{}", vec![num_for_a, num_for_b].iter().min().unwrap());

  // for i in 1..n + 1 {
  //   for comb in vec_ab.clone().into_iter().combinations(i as usize) {
  //     // check if the condition for X is satisfied
  //     let (total_a, total_b) = get_total(&comb);
  //     if total_a >= x && total_b >= y {
  //       println!("{}", comb.len());
  //       exit(0);
  //     }
  //   }
  // }
}

fn get_total(vec_bento: &Vec<Bento>) -> (u32, u32) {
  vec_bento
    .into_iter()
    .fold((0, 0), |acc, bento| (acc.0 + bento.a, acc.1 + bento.b))
}
