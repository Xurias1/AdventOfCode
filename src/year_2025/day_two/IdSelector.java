package year_2025.day_two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdSelector {

  public static List<String> generateAllIds(){
    File input = new File("src/year_2025/day_two/PuzzleInput.txt");
    String line;
    List<String> ids = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(input))) {
      line = br.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    List<String> ranges = new ArrayList<>(Arrays.asList(line.split(",")));

    for (String range : ranges) {
      String[] rangeArray = range.split("-");
      for (Long i = Long.parseLong(rangeArray[0]); i <= Long.parseLong(rangeArray[1]); i++) {
        ids.add(i.toString());
      }
    }

    return ids;
  }
}
