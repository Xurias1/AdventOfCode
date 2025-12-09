package year_2025.day_one;

public class Dial {
  private int dialPosition = 50;

  public Dial() {
  }

  public int rotateDial(char direction, int distance) {
    if (distance < 0) throw new IllegalArgumentException("distance must be >= 0");
    int start = dialPosition;
    int firstK;
    if (direction == 'R') {
      firstK = (100 - (start % 100)) % 100;
    } else if (direction == 'L') {
      firstK = (start % 100);
    } else {
      throw new IllegalArgumentException("Invalid direction: " + direction);
    }
    if (firstK == 0) firstK = 100;

    int hits = 0;
    if (firstK <= distance) {
      hits = 1 + (distance - firstK) / 100;
    }

    int movement = (direction == 'R') ? distance : -distance;
    dialPosition = Math.floorMod(start + movement, 100);

    return hits;
  }





  public int getDialPosition() {
    return dialPosition;
  }
}
