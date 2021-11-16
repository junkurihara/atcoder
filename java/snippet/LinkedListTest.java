import java.util.*;
import java.util.stream.Collectors;

public class LinkedListTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] word = sc.next().split("");
    LinkedList<String> list = new LinkedList<>(Arrays.stream(word).collect(Collectors.toList()));

    System.out.println(removeDuplicated(list).toString());

  }

  private static <T> LinkedList<T> removeDuplicated(LinkedList<T> list) {
    Deque<T> copied = new LinkedList<>();
    HashSet<T> hs = new HashSet<>();
    for (T node : list) {
      if (!hs.contains(node)) {
        hs.add(node);
        copied.addLast(node);
      }
    }
    return (LinkedList<T>) copied;
  }
}
