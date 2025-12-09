package year_2025.day_one.riddle_two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import year_2025.day_one.Dial;
import year_2025.day_one.DialRotation;

public class Main {

  public static void main(String[] args) {
    File input = new File("src/year_2025/day_one/PuzzleInput.txt");
    List<DialRotation> rotations = new ArrayList<>();
    Dial dial = new Dial();
    int hitsOnZero = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(input))) {
      String line;
      while ((line = br.readLine()) != null) {
        rotations.add(new DialRotation(line.charAt(0), Integer.parseInt(line.substring(1))));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    for (DialRotation rotation : rotations) {
      hitsOnZero += dial.rotateDial(rotation.getDirection(), rotation.getRotation());
    }

    System.out.println(hitsOnZero);

  }

}
