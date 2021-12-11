import java.util.*;

// 40億個の非負整数を含む入力ファイルが与えられた時、ファイルに含まれていない整数を生成するアルゴリズムを考えてください。
// このとき、1GBのメモリが利用できると仮定してください（32ビット符号付き整数）。
// 発展問題: メモリが10MBしかない場合はどのようにしますか？
// 全ての値は異なり、10億より大きな非負整数はないと仮定してください。

// 32bit int -> 2^32 ~= 4 * 1000^3 = 4G
// 2^31 = 2G, i.e, need 2G * 4B memory to store all natural numbers

public class SortAndSearch1007 {
  public static void main(String[] args) {
    long numberOfInts = 16; // ((long) Integer.MAX_VALUE) + 1; // 0...2^31
    byte[] bitVect = new byte[(int) (numberOfInts / 8)];

    int[] samples = { 0, 1, 2, 3, 4, 5, 6, 7 };
    for (int x : samples) {
      updateBitVect(x, bitVect);
    }
    System.out.println(findSmallestOpenNum(bitVect));

  }

  public static void updateBitVect(int x, byte[] bitVect) {
    bitVect[x / 8] |= 1 << (x % 8);
  }

  public static int findSmallestOpenNum(byte[] bitVect) {
    for (int i = 0; i < bitVect.length; i++) {
      if (bitVect[i] < 256) {
        for (int j = 0; j < 8; j++) {
          if ((bitVect[i] & (1 << j)) == 0) {
            return i * 8 + j;
          }
        }
      }
    }
    return -1;
  }

}
