use proconio::input;

#[derive(Debug)]
struct Shape {
  vec_char: Vec<Vec<char>>,
  rotated: [Vec<Vec<char>>; 4],
}

impl Shape {
  fn new(vec_string: Vec<String>) -> Shape {
    let mut vec_char: Vec<Vec<char>> = Vec::new();
    for s in vec_string {
      vec_char.push(s.chars().collect());
    }
    let reshaped: Vec<Vec<char>> = Shape::reshape(&vec_char);
    let rotate90 = Shape::rotate90(reshaped.clone());
    let rotate180 = Shape::rotate90(rotate90.clone());
    let rotate270 = Shape::rotate90(rotate180.clone());
    return Shape {
      vec_char,
      rotated: [reshaped, rotate90, rotate180, rotate270],
    };
  }

  fn reshape(rect: &Vec<Vec<char>>) -> Vec<Vec<char>> {
    let mut non_null_row_idx: Vec<usize> = Vec::new();
    for (r_idx, row) in rect.clone().into_iter().enumerate() {
      if !row.clone().iter().all(|p| *p == '.') {
        non_null_row_idx.push(r_idx);
      }
    }

    let mut non_null_col_idx: Vec<usize> = Vec::new();
    for c_idx in 0..rect[0].len() {
      for row in rect {
        if row[c_idx] != '.' {
          non_null_col_idx.push(c_idx);
          break;
        }
      }
    }

    let mut reshaped: Vec<Vec<char>> = Vec::new();
    let row_max = non_null_row_idx.iter().max().unwrap();
    let row_min = non_null_row_idx.iter().min().unwrap();
    let col_max = non_null_col_idx.iter().max().unwrap();
    let col_min = non_null_col_idx.iter().min().unwrap();
    for r_idx in *row_min..*row_max + 1 {
      let new_col: Vec<char> = (*col_min..*col_max + 1)
        .clone()
        .into_iter()
        .map(|c_idx| rect[r_idx][c_idx])
        .collect();
      reshaped.push(new_col);
    }

    return reshaped;
  }

  fn rotate90(to_be_reshaped: Vec<Vec<char>>) -> Vec<Vec<char>> {
    let mut rotated: Vec<Vec<char>> = Vec::new();
    let col_len = to_be_reshaped[0].len();
    for c_idx in 0..col_len {
      let mut new_row: Vec<char> = Vec::new();
      for row in &to_be_reshaped {
        new_row.push(row[row.len() - c_idx - 1]);
      }
      rotated.push(new_row);
    }

    return rotated;
  }

  fn rotated_string(&self) -> Vec<String> {
    let mut res: Vec<String> = Vec::new();
    for v in &self.rotated {
      let vect: Vec<String> = v
        .into_iter()
        .map(|v_char| v_char.iter().collect())
        .collect();
      res.push(vect.into_iter().collect::<Vec<_>>().join(""));
    }
    res
  }

  fn can_be_same(&self, cmp: Shape) -> bool {
    let self_rotated = self.rotated_string();
    let cmp_rotated = cmp.rotated_string();
    for s in self_rotated {
      for c in &cmp_rotated {
        if s == *c {
          return true;
        }
      }
    }
    return false;
  }
}

pub fn c_main() {
  input! {n: usize}
  let mut str_s: Vec<String> = Vec::new();
  let mut str_t: Vec<String> = Vec::new();
  for _ in 0..n {
    input! {s: String}
    str_s.push(s.chars().collect());
  }
  for _ in 0..n {
    input! {s: String}
    str_t.push(s.chars().collect());
  }
  let shape_s = Shape::new(str_s);
  let shape_t = Shape::new(str_t);

  if shape_s.can_be_same(shape_t) {
    println!("Yes");
  } else {
    println!("No");
  }
}
