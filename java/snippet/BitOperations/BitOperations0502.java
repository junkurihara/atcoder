import java.util.*;

// 0から1までの実数値がdouble型として与えられるとき、それを2進表記で表してください。
// 32文字以内で正確に表現できない場合は”ERROR"と出力してくださいい

public class BitOperations0502 {
  public static void main(String[] args) {
    double value = 0.875;

    String output = "0.";
    double div = 0.5;

    int counter = 0;
    while (value > 0) {
      if (counter >= 32) {
        System.out.println("ERROR");
        return;
      }

      if (value < div) {
        output += "0";
      } else {
        output += "1";
        value -= div;
      }
      div /= 2.0;
      counter += 1;
    }
    System.out.println(output);
  }
}
