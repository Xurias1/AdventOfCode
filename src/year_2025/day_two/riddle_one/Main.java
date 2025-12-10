package year_2025.day_two.riddle_one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import year_2025.day_two.IdSelector;

public class Main {

  public static void main(String[] args) {
    List<String> ids = IdSelector.generateAllIds();
    List<Long> faultyIds = new ArrayList<>();
    long sum = 0;

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
