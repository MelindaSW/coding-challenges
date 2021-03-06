import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class Day5PartTwo {
  public static void main(String[] args) throws FileNotFoundException {
    String filePath =
        "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day5.txt";
    Scanner scanner = new Scanner(new File(filePath));
    List<Integer> seatIDs = new ArrayList<>();

    while (scanner.hasNext()) {
      String seatCode = scanner.nextLine();
      int row = findRow(seatCode.substring(0, 7));
      int column = findColumn(seatCode.substring(7));
      int id = (row * 8) + column;
      seatIDs.add(id);
    }
    System.out.println(findSeat(seatIDs));
  }

  static int findSeat(List<Integer> seatIDs) {
    Collections.sort(seatIDs);
    for (int i = 0; i < seatIDs.size(); i++) {
      if (seatIDs.get(i) + 2 == seatIDs.get(i + 1)) {
        return seatIDs.get(i) + 1;
      }
    }
    return 0;
  }

  // TODO: Not very Dry... Could possibly be refactored into one method.

  static int findRow(String r) {
    int[] range = IntStream.rangeClosed(0, 127).toArray();
    for (int i = 0; i < 6; i++) {
      int mid = range.length / 2;
      int middleValue = range[mid];
      if (r.charAt(i) == 'B') {
        range = Arrays.stream(range).filter(v -> v >= middleValue).toArray();
      } else if (r.charAt(i) == 'F') {
        range = Arrays.stream(range).filter(v -> v <= middleValue).toArray();
      }
    }
    return r.endsWith("F") ? range[0] : range[1];
  }

  static int findColumn(String c) {
    int[] range = IntStream.rangeClosed(0, 7).toArray();
    for (int i = 0; i < 2; i++) {
      int mid = range.length / 2;
      int middleValue = range[mid];
      if (c.charAt(i) == 'R') {
        range = Arrays.stream(range).filter(v -> v >= middleValue).toArray();
      } else if (c.charAt(i) == 'L') {
        range = Arrays.stream(range).filter(v -> v <= middleValue).toArray();
      }
    }
    return c.endsWith("L") ? range[0] : range[1];
  }
}
