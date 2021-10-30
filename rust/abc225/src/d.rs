use proconio::input;
use std::io::{stdout, BufWriter, Write};

#[derive(Debug, Clone)]
struct Car {
  index: usize,
  front: Option<usize>,
  rear: Option<usize>,
}

impl Car {
  fn new(index: usize) -> Car {
    Car {
      index,
      front: None,
      rear: None,
    }
  }

  fn connect_rear(&mut self, behind_car_idx: usize) {
    self.rear = Some(behind_car_idx);
  }

  fn disconnect_rear(&mut self) {
    self.rear = None;
  }

  fn connect_front(&mut self, forward_car_idx: usize) {
    self.front = Some(forward_car_idx);
  }

  fn disconnect_front(&mut self) {
    self.front = None;
  }
}

fn get_all_connected_cars(idx: usize, cars: &Vec<Car>) -> Vec<usize> {
  let indexed_car = &cars[idx - 1];
  let mut forwards: Vec<usize> = Vec::new();
  let mut behinds: Vec<usize> = Vec::new();

  // forward
  let mut next = indexed_car;
  for _ in 0..cars.len() {
    match next.front {
      Some(c) => {
        forwards.push(c);
        next = &cars[c - 1];
      }
      None => {
        break;
      }
    }
  }
  forwards.reverse();
  // behind
  let mut next = indexed_car;
  for _ in 0..cars.len() {
    match next.rear {
      Some(c) => {
        behinds.push(c);
        next = &cars[c - 1];
      }
      None => {
        break;
      }
    }
  }
  forwards.extend(vec![indexed_car.index]);
  forwards.extend(behinds);
  return forwards;
}

pub fn main() {
  let out = stdout();
  let mut out = BufWriter::new(out.lock());

  input! {n: usize, q: usize}
  let mut queries: Vec<(usize, usize, usize)> = Vec::with_capacity(q);
  for _ in 0..q {
    input! {idx: usize, x: usize}
    if idx == 3 {
      queries.push((idx, x, 0));
    } else {
      input! {y: usize}
      queries.push((idx, x, y));
    }
  }
  let mut cars: Vec<Car> = (1..n + 1).map(|i| Car::new(i)).collect();

  for query in queries {
    if query.0 == 1 {
      cars[query.1 - 1].connect_rear(query.2);
      cars[query.2 - 1].connect_front(query.1);
    } else if query.0 == 2 {
      cars[query.1 - 1].disconnect_rear();
      cars[query.2 - 1].disconnect_front();
    } else {
      // display all for query.1
      let car_indices = get_all_connected_cars(query.1, &cars);
      write!(out, "{} ", car_indices.len()).unwrap();
      for c in car_indices {
        write!(out, "{} ", c).unwrap();
      }
      writeln!(out, "").unwrap();
    }
  }
}
