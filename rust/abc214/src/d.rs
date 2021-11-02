use proconio::input;
use std::collections::{HashMap, HashSet};

struct Node {
  index: usize,
  next_nodes: HashMap<usize, usize>,
}

impl Node {
  fn new(index: usize) -> Node {
    Node {
      index,
      next_nodes: HashMap::new(),
    }
  }
}

pub fn main() {
  input! {
    n: usize,
    uvw: [[usize; 3]; n - 1]
  }
  let mut node_map: HashMap<usize, Node> = (1..n + 1)
    .into_iter()
    .map(|idx| (idx, Node::new(idx)))
    .collect();
}
