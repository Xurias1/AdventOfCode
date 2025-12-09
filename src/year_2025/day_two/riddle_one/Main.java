package year_2025.day_two.riddle_one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    File input = new File("src/year_2025/day_two/PuzzleInput.txt");
    String line;
    List<String> ids = new ArrayList<>();
    List<Long> faultyIds = new ArrayList<>();
    long sum = 0;

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

    for (String id : ids) {
      String firstHalf = id.substring(0, id.length() / 2);
      String secondHalf = id.substring(id.length() / 2);
      if (firstHalf.equals(secondHalf)) {
        faultyIds.add(Long.parseLong(id));
      }
    }

    for( Long faultyId : faultyIds) {
      sum += faultyId;
    }

    System.out.println(sum);


  }

}
