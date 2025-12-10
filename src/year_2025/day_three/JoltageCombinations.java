package year_2025.day_three;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JoltageCombinations {

  public static List<Long> getJoltageCombinations(int combinationLength) {
    File input = new File("src/year_2025/day_three/PuzzleInput.txt");
    List<String> lines = new ArrayList<>();
    List<Long> combinedJoltages = new ArrayList<>();

    try (
        BufferedReader br = new BufferedReader(new FileReader(input))) {
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
    } catch (
        IOException e) {
      throw new RuntimeException(e);
    }

    for (String line : lines) {
      char[] chars = line.toCharArray();
      int[] joltages = new int[chars.length];
      for (int i = 0; i < chars.length; i++) {
        joltages[i] = Integer.parseInt(chars[i] + "");
      }
      combinedJoltages.add(getHighestJoltageCombination(joltages, 0, combinationLength));
    }

    return combinedJoltages;
  }

  private static Long getHighestJoltageCombination(int[] joltages, int startIndex,
      int combinationLength) {
    if (combinationLength == 0) {
      return 0L;
    }

    int highesJoltageIndex = startIndex;
    Long currentJoltage = 0L;
    for (int i = startIndex + 1; i < joltages.length - (combinationLength - 1); i++) {
      if (joltages[i] > joltages[highesJoltageIndex]) {
        highesJoltageIndex = i;
      }
    }
    currentJoltage = (long) joltages[highesJoltageIndex];
    for (int i = 0; i < combinationLength - 1; i++) {
      currentJoltage *= 10;
    }

    return currentJoltage + getHighestJoltageCombination(joltages, highesJoltageIndex + 1,
        combinationLength - 1);
  }
}
