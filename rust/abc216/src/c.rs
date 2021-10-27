use proconio::input;

fn rec_magic(num: usize) -> Vec<char> {
  if num == 1 {
    return vec!['A'];
  }
  let (next_num, next_magic) = if num % 2 == 1 {
    (num - 1, 'A')
  } else {
    (num / 2, 'B')
  };
  let mut v = rec_magic(next_num);
  v.push(next_magic);
  return v;
}

pub fn c_main() {
  input! { n: usize }
  let v = rec_magic(n);
  println!("{}", v.iter().collect::<String>());
}
