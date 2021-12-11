import java.util.*;

// 1からN全ての値を持つ配列があり、Nは最大で32,000とします。
// 配列は重複する要素を持ち、Nが幾つであるかは分かりません。
// 4KBしかメモリが使えないとして、配列内の重複する要素をどうやって出力すれば良いでしょうか。

// 4KB = 4 * 1024 * 8 > 32,000
public class SortAndSearch1008 {
  static final int MAX_N = 9; // 32_001;
  static final int[] samples = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 4, 6, 9 };

  public static void main(String[] args) {
    int byteLen;
    if (MAX_N % 8 == 0) {
      byteLen = MAX_N / 8;
    } else {
      byteLen = (MAX_N - (MAX_N % 8)) / 8 + 1;
    }
    byte[] bitVect = new byte[byteLen];
    for (int x : samples) {
      if (!tryToUpdateBitVect(x, bitVect)) {
        System.out.print(x + " ");
      }
    }
    System.out.println();

    BitSet bitSet = new BitSet();
    for (int x : samples) {
      if (bitSet.get(x)) {
        System.out.print(x + " ");
      } else {
        bitSet.set(x);
      }
    }
    System.out.println();
  }

  public static boolean tryToUpdateBitVect(int x, byte[] bitVect) {
    int bitLoc = 1 << ((x - 1) % 8);
    // System.out.println(x + " " + bitLoc + " " + bitVect[(x - 1) / 8]);
    if ((bitVect[(x - 1) / 8] & bitLoc) != 0) {
      return false;
    }
    bitVect[(x - 1) / 8] |= bitLoc;
    return true;
  }
}
