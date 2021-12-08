import java.util.*;

// 空の文字列が点在するソート済みの文字列配列があります。
// この配列の中から特定の文字列の位置を見つけるメソッドを書いてください。
// 入力: ball, {"at", "", "", "", "ball", "", "", "car", "", "dad", ""}
// 出力: 4

public class SortAndSearch1005 {
  public static void main(String[] args) {
    String[] array = { "at", "", "", "", "ball", "", "", "car", "", "dad", "" };
    String target = "ball";
    System.out.println(
        search(array, target, 0, array.length - 1));
  }

  private static int search(String[] strings, String target, int first, int last) {
    if (first > last) {
      return -1;
    }
    int mid = (last + first) / 2;

    if (strings[mid].isEmpty()) {
      int left = mid - 1;
      int right = mid + 1;
      while (true) {
        if (left < first && right > last) {
          return -1;
        } else if (right <= last && !strings[right].isEmpty()) {
          mid = right;
          break;
        } else if (left >= first && !strings[left].isEmpty()) {
          mid = left;
          break;
        }
        right += 1;
        left -= 1;
      }
    }

    if (target.equals(strings[mid])) {
      return mid;
    } else if (strings[mid].compareTo(target) < 0) {
      return search(strings, target, mid + 1, last);
    } else {
      return search(strings, target, first, mid - 1);
    }

  }

}
