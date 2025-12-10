package year_2025.day_one;

public class DialRotation {

  private final char direction;
  private final int rotation;

  public DialRotation(char direction, int rotation) {
    this.direction = direction;
    this.rotation = rotation;
  }

  public char getDirection() {
    return direction;
  }

  public int getRotation() {
    return rotation;
  }
}
