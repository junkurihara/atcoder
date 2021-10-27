use proconio::input;

fn calc_local_sum(vec_a: &[u64]) -> u64 {
  vec_a.iter().fold(0, |acc, x| acc + x)
}

pub fn c_main() {
  input! {
    n: u64
  }
  input! {
    a: [u64; n]
  }
  input! {
    x: u64
  }

  let local_total = calc_local_sum(&a);

  let residue = x % local_total;
  let base_factor = (x - residue) / local_total;

  let mut extra = 0;
  let mut extra_idx = 0;
  for p in a {
    if residue < extra {
      break;
    }
    extra += p;
    extra_idx += 1;
  }
  println!("{}", base_factor * n + extra_idx);
}
