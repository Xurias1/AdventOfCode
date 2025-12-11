package year_2025.day_four.riddle_one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    File input = new File("src/year_2025/day_four/PuzzleInput.txt");
    List<List<Character>> paperStorage = new ArrayList<>();
    int accesibleRolls = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(input))) {
      String line;
      while ((line = br.readLine()) != null) {
        char[] positions = line.toCharArray();
        paperStorage.add(new ArrayList<>());
        for (char position : positions) {
          paperStorage.getLast().add(position);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    for (int x = 0; x < paperStorage.size(); x++) {
      for (int y = 0; y < paperStorage.get(x).size(); y++) {
        if (paperStorage.get(x).get(y) == '@'
            && getPaperrollCount(getSurrounding(paperStorage, x, y)) < 4) {
          accesibleRolls++;
        }
      }
    }

    System.out.println(accesibleRolls);
  }

  private static List<Character> getSurrounding(List<List<Character>> paperStorage, int xPos,
      int yPos) {
    List<Character> surrounding = new ArrayList<>();
    for (int x = xPos - 1; x <= xPos + 1; x++) {
      for (int y = yPos - 1; y <= yPos + 1; y++) {
        if (x < 0 || x > paperStorage.size() - 1 || y < 0 || y > paperStorage.size() - 1) {
          surrounding.add('.');
          continue;
        } else if (x == xPos && y == yPos) {
          continue;
        }
        surrounding.add(paperStorage.get(x).get(y));
      }
    }
    return surrounding;
  }

  private static int getPaperrollCount(List<Character> surrounding) {
    int count = 0;
    for (char c : surrounding) {
      if (c == '@') {
        count++;
      }
    }
    return count;
  }
}
