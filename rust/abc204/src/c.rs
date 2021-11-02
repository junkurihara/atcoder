use proconio::input;
use std::collections::{HashMap, HashSet};
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: u32, m: u32, ab: [(u32, u32); m]}

  let mut hm: HashMap<u32, Vec<u32>> = HashMap::new();
  for road in ab {
    let hm_entry = hm.entry(road.0).or_insert(Vec::new());
    hm_entry.push(road.1)
  }

  let mut cnt = 0;
  for start in 1..n + 1 {
    let mut stamp: HashSet<u32> = HashSet::new();
    stamp.insert(start);
    find_nexts(&start, &mut stamp, &hm);
    cnt += stamp.len();
  }
  writeln!(out, "{}", cnt).unwrap();
}

fn find_nexts(current: &u32, stamp: &mut HashSet<u32>, hm: &HashMap<u32, Vec<u32>>) {
  if let Some(nexts) = hm.get(&current) {
    for node in nexts {
      if !stamp.contains(node) {
        stamp.insert(*node);
        find_nexts(node, stamp, hm);
      }
    }
  }
}
