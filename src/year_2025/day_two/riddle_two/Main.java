package year_2025.day_two.riddle_two;

import java.util.ArrayList;
import java.util.List;
import year_2025.day_two.IdSelector;

public class Main {

  public static void main(String[] args) {
    List<String> ids = IdSelector.generateAllIds();
    List<Long> faultyIds = new ArrayList<>();
    long sum = 0;

    for (String id : ids) {
      boolean faulty = false;
      List<Integer> fullDivisors = new ArrayList<>();
      for (int i = id.length(); i > 1; i--) {
        if (id.length() % i == 0) {
          fullDivisors.add(i);
        }
      }
      for( int divisor : fullDivisors) {
        faulty = checkRepetetive(id, divisor);
        if (faulty) {
          faultyIds.add(Long.parseLong(id));
          break;
        }
      }
    }

    for( Long faultyId : faultyIds) {
      sum += faultyId;
    }

    System.out.println(sum);
  }

  private static boolean checkRepetetive(String id, int substringCount){
    List<String> idSubstrings = new ArrayList<>();
    String remainingIDSubstring = id;

    while (remainingIDSubstring.length() >= id.length()/substringCount){
      idSubstrings.add(remainingIDSubstring.substring(0, id.length()/substringCount));
      remainingIDSubstring = remainingIDSubstring.substring(id.length()/substringCount);
    }

    for (int i = 1; i < idSubstrings.size(); i++) {
      if (!(idSubstrings.get(i).equals(idSubstrings.getFirst()))){
        return false;
      }
    }

    return true;
  }
}
