import java.util.*;
import java.util.stream.Collectors;

// ある集合のすべての部分集合を返すメソッドを書いてください

public class RecursionAndDP0804 {
  public static void main(String[] args) {
    int n = 10;

    ArrayList<ArrayList<Integer>> powerSets = new ArrayList<>();
    powerSets.add(new ArrayList<>());

    for (int i = 1; i <= n; i++) {
      powerSets = updateSubsets(powerSets, i);
    }

    for (ArrayList<Integer> elem : powerSets) {
      System.out.println(elem.toString());
    }
  }

  static ArrayList<ArrayList<Integer>> updateSubsets(ArrayList<ArrayList<Integer>> powerSets, int newIndex) {
    ArrayList<ArrayList<Integer>> newPowerSets = new ArrayList<>();
    newPowerSets.addAll(powerSets);

    powerSets.stream().forEach(elem -> {
      ArrayList<Integer> copied = new ArrayList<>();
      copied.addAll(elem);
      copied.add(newIndex);
      newPowerSets.add(copied);
    });

    return newPowerSets;
  }
}
