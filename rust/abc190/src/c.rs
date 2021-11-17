use proconio::input;
use std::collections::HashSet;
use std::io::{stdout, BufWriter, Write};

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());
  input! {n: usize, m: usize, ab: [(usize, usize); m]}
  input! {k: usize, cd: [(usize, usize); k]};
  let rule = Rule { ab };

  let mut copied_person = cd.clone();
  let max_val = rule.recursive_calc(&mut copied_person);
  writeln!(out, "{}", max_val).unwrap();
}

struct Rule {
  ab: Vec<(usize, usize)>,
}

impl Rule {
  fn recursive_calc(&self, remained: &mut Vec<(usize, usize)>) -> usize {
    let mut hs: HashSet<usize> = HashSet::new();
    self._recursive_calc(remained, &mut hs)
  }

  fn _recursive_calc(&self, remained: &mut Vec<(usize, usize)>, hs: &mut HashSet<usize>) -> usize {
    match remained.pop() {
      None => {
        return self
          .ab
          .iter()
          .filter(|(a, b)| hs.contains(&a) && hs.contains(&b))
          .collect::<Vec<&(usize, usize)>>()
          .len();
      }
      Some(popped) => {
        let mut cloned_remained_1 = remained.clone();
        let mut cloned_hs_1 = hs.clone();
        cloned_hs_1.insert(popped.0);
        let val_1 = self._recursive_calc(&mut cloned_remained_1, &mut cloned_hs_1);

        let mut cloned_remained_2 = remained.clone();
        let mut cloned_hs_2 = hs.clone();
        cloned_hs_2.insert(popped.1);
        let val_2 = self._recursive_calc(&mut cloned_remained_2, &mut cloned_hs_2);
        return val_1.max(val_2);
      }
    }
  }
}
