package year_2025.day_three.riddle_one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import year_2025.day_three.JoltageCombinations;

public class Main {

  public static void main(String[] args) {
    List<Long> combinedJoltages;
    Long sum = 0L;

    combinedJoltages = JoltageCombinations.getJoltageCombinations(2);
    for (Long joltage : combinedJoltages) {
      sum += joltage;
    }
    System.out.println(sum);
  }
}
