import java.util.*;

// 行と列がソートされたM x Nの行列があります。
// この行列からある要素を見つけるメソッドを書いてください。

public class SortAndSearch1010 {
  public static void main(String[] args) {
    int[][] mat = {
        { 15, 20, 40, 85 },
        { 20, 35, 80, 95 },
        { 30, 55, 95, 105 },
        { 40, 80, 100, 120 }
    };
    int target = 120;
    System.out.println(Arrays.toString(simpleBS(mat, target)));
    System.out.println(Arrays.toString(findElem(mat, target)));
    System.out.println(Arrays.toString(complexBS(mat, target)));
  }

  public static int[] complexBS(int[][] mat, int target) {
    int rowStart = 0;
    int colStart = 0;
    int rowEnd = mat.length - 1;
    int colEnd = mat[0].length - 1;

    return tupleBS(mat, rowStart, colStart, rowEnd, colEnd, target);
  }

  public static int[] tupleBS(int[][] mat, int rowStart, int colStart, int rowEnd, int colEnd, int target) {
    System.out.println(rowStart + " " + rowEnd + " " + colStart + " " + colEnd);
    if (rowStart > rowEnd || colStart > colEnd) {
      int[] res = { -1, -1 };
      return res;
    }
    int rowMid = (rowStart + rowEnd) / 2;
    int colMid = (colStart + colEnd) / 2;
    if ((rowStart == rowEnd || rowStart == rowEnd - 1)
        && (colStart == colEnd || colStart == colEnd - 1)) {
      for (int i = rowStart; i <= rowEnd; i++) {
        int bsResult = binarySearch(mat[i], colStart, colEnd, target);
        if (bsResult != -1) {
          int[] res = { i, bsResult };
          return res;
        }
      }
      int[] res = { -1, -1 };
      return res;
    }
    if (mat[rowMid][colMid] < target) {
      return tupleBS(mat, rowMid, colMid, rowEnd, colEnd, target);
      // return binarySearch(array, left, mid - 1, target);
    }
    return tupleBS(mat, rowStart, colStart, rowMid, colMid, target);
    // return binarySearch(array, mid + 1, right, target);

  }

  public static int[] findElem(int[][] mat, int target) {
    int row = 0;
    int col = mat[0].length - 1;
    int[] res = { -1, -1 };
    while (row < mat.length && col >= 0) {
      if (mat[row][col] == target) {
        res[0] = row;
        res[1] = col;
        return res;
      }
      if (mat[row][col] > target) {
        col--;
      } else {
        row++;
      }
    }
    return res;
  }

  public static int[] simpleBS(int[][] mat, int target) {
    // search each row
    for (int i = 0; i < mat.length; i++) {
      int bsResult = binarySearch(mat[i], 0, mat[i].length - 1, target);
      if (bsResult != -1) {
        int[] res = { i, bsResult };
        return res;
      }
    }
    int[] res = { -1, -1 };
    return res;

  }

  public static int binarySearch(int[] array, int left, int right, int target) {
    if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (array[mid] == target) {
      return mid;
    }
    if (array[mid] > target) {
      return binarySearch(array, left, mid - 1, target);
    }
    return binarySearch(array, mid + 1, right, target);
  }
}
