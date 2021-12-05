import java.util.*;

public class LinkedList0201 {
  public void deleteDups(LinkedList<Integer> list) {
    HashSet<Integer> hs = new HashSet<>();

    for (Integer num : list) {
      if (hs.contains(num)) {
        list.remove(num);
      } else {
        hs.add(num);
      }
    }
  }

  public void deleteDupsWithoutBuffer(LinkedList<Integer> list) {

    for (int i = 0; i < list.size(); i++) {
      var val = list.get(i);
      for (int j = i + 1; j < list.size(); j++) {
        if (val.equals(list.get(j))) {
          list.remove(j);
        }
      }
    }
  }
}
