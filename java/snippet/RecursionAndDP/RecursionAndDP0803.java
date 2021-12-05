import java.util.*;

// ある配列A[0...n-1]についてA[i]=iとなるインデックスiをマジックインデックスとします。
// 異なる整数で照準にソートされた配列が与えられた時、マジックインデックスが存在するとすれば、それを探し出すメソッドを書いてください。

public class RecursionAndDP0803 {
  public int bruteforce(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == i) {
        return i;
      }
    }
    return -1;
  }

  public int bst(int[] array) {
    return bst(array, 0, array.length - 1);
  }

  public int bst(int[] array, int startIdx, int endIdx) {
    if (endIdx < startIdx) {
      return -1;
    }
    int mid = (startIdx + endIdx) / 2;
    if (array[mid] == mid) {
      return mid;
    } else if (array[mid] > mid) {
      return bst(array, start, mid - 1);
    } else {
      return bst(array, mid + 1, end);
    }
  }

  public int bst2(int[] array) {
    return bst2(array, 0, array.length - 1);
  };

  public int bst2(int[] array, int startIdx, int endIdx) {
    if (endIdx < startIdx) {
      return -1;
    }

    int midIdx = (startIdx + endIdx) / 2;
    int midVal = array[midIdx];
    if (midIdx == midVal) {
      return midIdx;
    }

    // search left
    int leftIdx = Math.min(midIdx - 1, midVal);
    int left = bst2(array, start, leftIdx);
    if (left >= 0) {
      return left;
    }

    int rightIdx = Math.max(midIdx + 1, midVal);
    int right = bst2(array, rightIdx, end);
    return right;
  }
}
