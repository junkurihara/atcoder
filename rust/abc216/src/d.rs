use proconio::input;
use std::collections::{HashMap, HashSet};
use std::process::exit;

#[derive(Debug, Clone)]
struct Pipe {
  balls: Vec<usize>,
  length: usize,
}

#[derive(Debug, Clone)]
struct TopColors(HashMap<usize, Vec<usize>>, Vec<usize>);
impl TopColors {
  fn pop_dup(mut self) -> Option<(usize, usize, usize)> {
    // let mut hs: HashMap<usize, usize> = HashMap::new();
    // for i in 0..self.0.len() {
    //   if hs.contains_key(&self.0[i]) {
    //     let j: usize = *hs.get(&self.0[i]).unwrap();
    //     return Some((j, i));
    //   }
    //   hs.insert(self.0[i], i);
    // }
    if let Some(dup_color) = self.1.pop() {
      let v = self.0.get(&dup_color).unwrap();
      return Some((v[0], v[1], dup_color));
    } else {
      return None;
    }
  }
  fn add(&mut self, color: usize, idx: usize) {
    if let Some(v) = self.0.get(&color) {
      let mut vc = v.clone();
      vc.push(idx);
      self.0.insert(color, vc);
      self.1.push(color);
    } else {
      self.0.insert(color, vec![idx]);
    }
  }
  fn remove(&mut self, color: usize) {
    self.0.remove(&color);
  }
}

pub fn main() {
  input! {
    n: usize,
    m: usize,
  }
  let mut pipes: Vec<Pipe> = Vec::new();
  for _ in 0..m {
    input! {k: usize, balls: [usize; k]}
    pipes.push(Pipe { balls, length: k });
  }
  let mut top_colors: TopColors = TopColors(HashMap::new(), Vec::new());

  for (i, p) in pipes.clone().into_iter().enumerate() {
    top_colors.add(p.balls[0], i);
  }

  let mut ptr: Vec<usize> = vec![0; m];

  // println!("{:?}, {:?}", ptr, top_colors);
  let mut maximum = n + 1;
  for _ in 0..n {
    match top_colors.clone().pop_dup() {
      Some(dup) => {
        println!("{:?}", top_colors.1);
        let target_1 = dup.0;
        let target_2 = dup.1;
        let dup_color = dup.2;
        let ptr_1 = ptr[target_1];
        let ptr_2 = ptr[target_2];

        assert!(ptr_1 < pipes[target_1].length && ptr_2 < pipes[target_2].length);
        ptr[dup.0] = ptr_1 + 1;
        ptr[dup.1] = ptr_2 + 1;

        top_colors.remove(dup_color);

        if ptr_1 + 1 < pipes[target_1].length {
          top_colors.add(pipes[target_1].balls[ptr_1 + 1], target_1);
        } else {
          top_colors.add(maximum, target_1);
          maximum += 1;
        }

        if ptr_2 + 1 < pipes[target_2].length {
          top_colors.add(pipes[target_2].balls[ptr_2 + 1], target_2);
        } else {
          top_colors.add(maximum, target_2);
          maximum += 1;
        }
      }
      None => {
        println!("No");
        exit(0);
      }
    }
    // println!("{:?}, {:?}", ptr, top_colors);
  }
  println!("Yes");
}
