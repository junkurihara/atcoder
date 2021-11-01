import java.util.*;

class Car {
  public int index;
  public Car front;
  public Car rear;

  Car(int index) {
    this.index = index;
    this.front = null;
    this.rear = null;
  }

  public void connect_as_front(Car rear_car) {
    this.rear = rear_car;
    rear_car.front = this;
  }

  public void disconnect_as_front() {
    this.rear.front = null;
    this.rear = null;
  }

  public void print_sequence() {
    int cnt = 1;
    String str = "";
    Car ptr = this.front;
    while (ptr != null) {
      str = ptr.index + " " + str;
      ptr = ptr.front;
      cnt += 1;
    }
    str = str + this.index;
    ptr = this.rear;
    while (ptr != null) {
      str = str + " " + ptr.index;
      ptr = ptr.rear;
      cnt += 1;
    }
    System.out.println(cnt + " " + str);
  }
}

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();
    HashMap<Integer, int[]> cars = new HashMap<>();

    for (int i = 0; i < N; i++) {
      // Car c = new Car(i + 1);
      int[] c = { 0, 0 };
      cars.put(i + 1, c);
    }

    for (int i = 0; i < Q; i++) {
      int type = sc.nextInt();
      int x = sc.nextInt();
      int y = (type == 3) ? 0 : sc.nextInt();

      if (type == 1) {
        int[] c1 = cars.get(x);
        int[] c2 = cars.get(y);
        int[] newC1 = { c1[0], y };
        int[] newC2 = { x, c2[1] };
        cars.put(x, newC1);
        cars.put(y, newC2);
        // cars.get(x - 1).connect_as_front(cars.get(y - 1));
      } else if (type == 2) {
        int[] c1 = cars.get(x);
        int[] c2 = cars.get(y);
        int[] newC1 = { c1[0], 0 };
        int[] newC2 = { 0, c2[1] };
        cars.put(x, newC1);
        cars.put(y, newC2);
        // cars.get(x - 1).disconnect_as_front();
      } else {
        int cnt = 1;
        String str = "";
        int[] this_car = cars.get(x);
        int ptr = this_car[0];
        while (ptr != 0) {
          str = ptr + " " + str;
          ptr = cars.get(ptr)[0];
          cnt += 1;
        }
        str = str + x;
        ptr = this_car[1];
        while (ptr != 0) {
          str = str + " " + ptr;
          ptr = cars.get(ptr)[1];
          cnt += 1;
        }
        System.out.println(cnt + " " + str);
        // cars.get(x - 1).print_sequence();
      }
    }

  }
}
