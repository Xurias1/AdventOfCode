package year_2025.day_three.riddle_two;

import java.util.List;
import year_2025.day_three.JoltageCombinations;

public class Main {

  public static void main(String[] args) {
    List<Long> combinedJoltages;
    Long sum = 0L;

    combinedJoltages = JoltageCombinations.getJoltageCombinations(12);
    for (Long joltage : combinedJoltages) {
      sum += joltage;
    }
    System.out.println(sum);
  }
}
