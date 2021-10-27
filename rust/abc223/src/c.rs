use proconio::input;

#[derive(Debug, Clone)]
struct Doukasen {
  length: f64,
  speed: f64,
  lifetime: f64,
  accumulated_time: f64,
  accumulated_len: f64,
}
impl Doukasen {
  pub fn new(ai: usize, bi: usize, chain: &Vec<Doukasen>) -> Doukasen {
    let lifetime = (ai as f64) / (bi as f64);
    let (accumulated_time, accumulated_len) = match chain.len() {
      0 => (lifetime, (ai as f64)),
      _ => (
        lifetime + chain[chain.len() - 1].accumulated_time,
        (ai as f64) + chain[chain.len() - 1].accumulated_len,
      ),
    };
    Doukasen {
      length: ai as f64,
      speed: bi as f64,
      lifetime,
      accumulated_time,
      accumulated_len,
    }
  }
}

pub fn c_main() {
  input! {
    n: usize
  }

  let mut lines: Vec<Doukasen> = Vec::new();
  for _ in 0..n {
    input! {
      ai: usize,
      bi: usize,
    }
    lines.push(Doukasen::new(ai, bi, &lines));
  }
  let matched_time = lines[lines.len() - 1].accumulated_time / 2.0;
  let mut matched_idx = 0;
  for i in 0..lines.len() {
    if lines[i].accumulated_time > matched_time {
      break;
    }
    matched_idx = i;
  }

  let remained_time = matched_time - lines[matched_idx].accumulated_time;
  let remained_len = remained_time * lines[matched_idx + 1].speed;
  println!("{}", remained_len + lines[matched_idx].accumulated_len);
}
