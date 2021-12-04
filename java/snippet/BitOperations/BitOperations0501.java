import java.util.*;

// 最大32ビットの整数Nと、ビットの位置を示す値iとjが与えられています。
// このとき、Nのjビット目からiビット目をMを挿入するメソッドを書いてください。
// ただし、jとiの幅はMのビット数と一致していると仮定して構いません。
// つまり、M=10011であればjとiの幅は5と仮定して構いません。
// j=3, i=2のような、Mの幅と合わないような場合は考えなくて構わないということです。
// 例:
// input: N=10_000_000_000, M=10011, i=2, j=6
// output: N=10_001_001_100

public class BitOperations0501 {
  public static void main(String[] args) {
    long N = Long.parseLong("10000000000", 2);
    long M = Long.parseLong("10011", 2);
    long i = 2;
    long j = 6;

    long mask = ~0;
    System.out.println(Long.toBinaryString(mask));
    long left = mask << (j + 1);
    long right = (1 << i) - 1;
    mask = left | right;
    System.out.println(Long.toBinaryString(mask));

    System.out.println(Long.toBinaryString(N));
    N = mask & N;
    System.out.println(Long.toBinaryString(M << i));
    N = N | (M << i);

    System.out.println(Long.toBinaryString(N));
  }
}
