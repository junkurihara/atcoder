import java.util.*;

// n個の整数からなる、ソート済みの配列を何回か回転させたものがあります。
// この配列の中から、ある要素を見つけるコードを書いてください。
// 配列は初め照準でソートされていたと仮定しても構いません。
// 例:
// 入力 find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
// 出力 ８ (配列中の5のインデックス)

public class SortAndSearch1003 {
  public static void main(String[] args) {
    int[] array = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
    int target = 5;
    System.out.println(search(array, target));
    // sort(strs);
  }

  private static int search(int[] array, int target) {
    return bs(array, 0, array.length - 1, target);
  }

  private static int bs(int[] array, int left, int right, int target) {
    int mid = (left + right) / 2;
    if (target == array[mid]) {
      return mid;
    }
    if (right < left) {
      return -1;
    }

    if (array[left] < array[mid]) {
      if (target >= array[left] && target < array[mid]) {
        return bs(array, left, mid - 1, target);
      } else {
        return bs(array, mid + 1, right, target);
      }
    } else if (array[mid] < array[left]) {
      if (target >= array[mid] && target < array[left]) {
        return bs(array, mid + 1, right, target);
      } else {
        return bs(array, left, mid - 1, target);
      }
    } else if (array[left] == array[mid]) {
      if (array[mid] != array[right]) {
        return bs(array, mid + 1, right, target);
      } else {
        int resultLeft = bs(array, left, mid - 1, target);
        if (resultLeft == -1) {
          return bs(array, mid + 1, right, target);
        } else {
          return resultLeft;
        }
      }
    }

    return -1;
  }

}
