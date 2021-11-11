use proconio::input;
// use proconio::marker::Chars;
use std::cell::RefCell;
use std::io::{stdout, BufWriter, Write};
use std::rc::Rc;

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: u32, m: u32} // n: edge num, m: path num
  let mut graph: Vec<Rc<RefCell<Node>>> = Vec::new();
  for i in 1..n + 1 {
    graph.push(Rc::new(RefCell::new(Node::new(i))));
  }
  for _ in 0..m {
    input! {from: usize, to: usize}
    let rc = graph.get(to - 1).unwrap().clone();
    let root = graph.get_mut(from - 1).unwrap();
    root.borrow_mut().add_child(rc);
  }

  input! {root_idx: u32, target_idx: u32}
  let mut visited: Vec<bool> = vec![false; n as usize];

  search_dfs(
    graph.get(root_idx as usize - 1).unwrap(),
    &mut visited,
    target_idx,
  );

  // println!("{:#?}", graph);
}

fn search_dfs(root: &Rc<RefCell<Node>>, stamp: &mut Vec<bool>, target: u32) {
  println!("Visited {}", root.borrow().idx);
  if target == root.borrow().idx {
    println!("Found!");
    return;
  }
  stamp[root.borrow().idx as usize - 1] = true;

  for n in root.borrow().children.iter() {
    // println!("{} next => {}", root.borrow().idx, n.borrow().idx);
    if stamp[n.borrow().idx as usize - 1] == false {
      search_dfs(n, stamp, target);
    }
  }
}

#[derive(Debug, Clone)]
struct Node {
  idx: u32,
  children: Vec<Rc<RefCell<Node>>>,
}

impl Node {
  pub fn new(idx: u32) -> Self {
    Node {
      idx,
      children: Vec::new(),
    }
  }

  fn add_child(&mut self, child: Rc<RefCell<Node>>) {
    self.children.push(child);
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
