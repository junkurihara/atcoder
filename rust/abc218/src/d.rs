use itertools::Itertools;
use proconio::input;
use std::collections::{HashMap, HashSet};

pub fn d_main() {
  input! {n: usize}
  let mut hs_points: HashSet<(usize, usize)> = HashSet::new();
  for _ in 0..n {
    input! {p: [usize; 2]}
    hs_points.insert((p[0], p[1]));
  }
  println!("ok");

  let two_points: HashMap<(usize, usize, usize, usize), Vec<(usize, usize)>> = hs_points
    .clone()
    .into_iter()
    .combinations(2)
    .filter(|v| v[0].0 != v[1].0 && v[0].1 != v[1].1)
    .map(|p| {
      (
        (
          *vec![p[0].0, p[1].0].iter().min().unwrap(),
          *vec![p[0].0, p[1].0].iter().max().unwrap(),
          *vec![p[0].1, p[1].1].iter().min().unwrap(),
          *vec![p[0].1, p[1].1].iter().max().unwrap(),
        ),
        p,
      )
    })
    .collect::<HashMap<(usize, usize, usize, usize), Vec<(usize, usize)>>>();
  println!("{}", two_points.len());
  // let mut two_points_pruned: HashSet<Vec<(usize, usize)>> = HashSet::new();
  // for p2 in two_points {
  //   if !two_points_pruned.contains(&vec![(p2[0].0, p2[1].1), (p2[1].0, p2[0].1)])
  //     && !two_points_pruned.contains(&vec![(p2[1].0, p2[0].1), (p2[0].0, p2[1].1)])
  //   {
  //     two_points_pruned.insert(p2);
  //   }
  // }
  // println!("{}", two_points_pruned.len());

  // let mut matched: HashSet<((usize, usize), (usize, usize))> = HashSet::new();
  let mut cnt = 0;
  for p2 in two_points {
    // println!("{:?}", p2);
    let pa: (usize, usize) = (p2.1[0].0, p2.1[1].1);
    let pb: (usize, usize) = (p2.1[1].0, p2.1[0].1);
    if hs_points.contains(&pa) && hs_points.contains(&pb) {
      cnt += 1;
      // matched.insert((p2[0], p2[1]));
      // let mut vec_rect = Vec::new();
      // vec_rect.push(p2[0]);
      // vec_rect.push(p2[1]);
      // vec_rect.push(pa);
      // vec_rect.push(pb);
      // vec_rect.sort();
      // matched.insert(vec_rect);
    }
  }
  // println!("{:?}", matched);
  // println!("{:?}", matched.len());
  println!("{}", cnt);
}
