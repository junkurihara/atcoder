// 配列ににたsizeメソッドがないリストのようなデータ構造が与えられます。
// しかしelementAt(i)というインデックスiの要素をO(1)で返すメソッドはあります。
// もしiがデータ構造の範囲を超えていたら、-1を返します。(このためデータ構造は性の整数値しか扱いません)
// ソート済みで正の整数値を持つ、リストのようなデータ構造が与えられた時、要素xのインデックスを見つけてください。
// xが複数含まれる場合はどのインデックスを返しても構いません。

public class SortAndSearch1004 {
  public static void main(String[] args) {

  }

  class ListLike {
    public static int elementAt(int i) {
      int dummy = 0;
      return dummy;
    }
  }

  private int search(ListLike list, int target) {
    int index = 1;
    while (list.elementAt(index) != -1 && list.elementAt(index) < target) {
      index *= 2;
    }
    return bs(list, target, index / 2, index);
  }

  private int bs(ListLike list, int target, int left, int right) {
    int mid;

    while (left <= right) {
      mid = (left + right) / 2;
      int midValue = list.elementAt(mid);
      if (midValue > target || midValue == -1) {
        left -= 1;
      } else if (midValue < target) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
