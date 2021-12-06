import java.util.*;

// 2つのソートされた配列A、Bがあります。
// Aの配列には十分に空きがあり、後ろにBを追加することができます。
// このとき、BをAにソートされた状態でマージするメソッドを書いてください。

public class SortAndSearch1001 {
  public static void main(String[] args) {
    int[] array1 = { 1, 2, 3, 4, 5, 6, 0, 0, 0, 0 };
    int array1Len = 6;
    int[] array2 = { 3, 4, 5, 6 };
    int array2Len = 4;
    merge(array1, array1Len, array2, array2Len);
    Arrays.stream(array1).forEach(x -> System.out.println(x));
  }

  private static void merge(int[] array1, int array1Len, int[] array2, int array2Len) {
    int idx1 = array1Len - 1;
    int idx2 = array2Len - 1;
    int idxMerged = array1Len + array2Len - 1;
    System.out.println(idxMerged);

    while (idx2 >= 0) {
      if (idx1 >= 0 && array1[idx1] > array2[idx2]) {
        array1[idxMerged] = array1[idx1];
        idx1 -= 1;
      } else {
        array1[idxMerged] = array2[idx2];
        idx2 -= 1;
      }
      idxMerged -= 1;
    }
  }
}
