use proconio::input;
use std::collections::{HashMap, HashSet};
use std::io::{stdout, BufWriter, Write};

// struct Mapper {
//   hm: HashMap<u32, Vec<u32>>,
// }

// impl Mapper {
//   fn new(n: u32, ab: &Vec<(u32, u32)>) -> Mapper {
//     // make star-like structure as a tree
//     let mut hm: HashMap<u32, Vec<u32>> = HashMap::new();
//     let mut hm_r: HashMap<u32, Vec<u32>> = HashMap::new();
//     let mut visited: HashSet<u32> = HashSet::new();

//     for (a, b) in ab {
//       // always a < b
//       hm.entry(*a).or_insert(Vec::new()).push(*b);
//       hm_r.entry(*b).or_insert(Vec::new()).push(*a);
//     }
//     let mut ptr = 1;
//     for i in 1..n + 1 {
//       visited.insert(ptr);
//       if let Some(forward) = hm.get(&ptr) {
//         println!("{:?}", forward);
//       }
//     }
//     return Mapper { hm };
//   }
//   fn find_nexts() {}

//   fn ugly_step_count(&self, from: u32, to: u32) -> u32 {
//     if let Some(vect) = self.hm.get(&from) {
//       if vect.contains(&to) {
//         return 1;
//       }
//       for v in vect {
//         let cnt = self.ugly_step_count(*v, to);
//         if cnt > 0 {
//           return cnt + 1;
//         }
//       }
//     }
//     return 0;
//   }
// }

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  // input! {n: u32, q: u32, ab: [(u32, u32); n-1], cd: [(u32, u32); q]}

  // let mapper = Mapper::new(n, &ab);

  // for (c, d) in cd {
  //   let cnt = mapper.ugly_step_count(c, d);

  //   writeln!(out, "{}", cnt);
  // }

  // writeln!(out, "{:?}", hs);
  // writeln!(out, "{:?}", hs_r);
}
//     1-2-3
// 7-5-6/\4
//  star-like structure
// to reach the destination, we need at most q queries on the hash table.
