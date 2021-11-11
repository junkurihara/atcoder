use proconio::input;
// use proconio::marker::Chars;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: u32, m: u32} // n: edge num, m: path num
  let mut graph: Vec<Node> = Vec::new();
  for i in 1..n + 1 {
    graph.push(Node::new(i));
  }
  for _ in 0..m {
    input! {from: usize, to: usize}
    let child = graph[to - 1].clone();
    println!("{:?}", child);
    graph[from - 1].add_child(&child);
  }

  input! {root_idx: u32, target_idx: u32}
  let mut visited: Vec<bool> = vec![false; n as usize];

  search_dfs(&graph[root_idx as usize - 1], &mut visited, target_idx);

  println!("{:#?}", graph);
}

fn search_dfs(root: &Node, stamp: &mut Vec<bool>, target: u32) {
  println!("Visited {}", root.idx);
  if target == root.idx {
    println!("Found!");
    return;
  }
  stamp[root.idx as usize - 1] = true;

  for n in root.children.iter() {
    println!("{} next => {}", root.idx, n.idx);
    if stamp[n.idx as usize - 1] == false {
      search_dfs(n, stamp, target);
    }
  }
}

#[derive(Debug, Clone)]
struct Node {
  idx: u32,
  children: Vec<Node>,
}

impl Node {
  pub fn new(idx: u32) -> Self {
    return Node {
      idx,
      children: Vec::new(),
    };
  }

  fn add_child(&mut self, child: &Node) {
    self.children.push(child.clone());
  }
}

/*
6 5
2 1
2 3
4 2
4 5
5 6
4
6
// root 4
// find 6
*/
