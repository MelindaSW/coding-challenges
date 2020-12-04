import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3PartOne {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner =
        new Scanner(
            new File(
                "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day3.txt"));
    String firstLine = scanner.nextLine();
    int oneGridLength = firstLine.length();
    int treeCounter = 0;
    int position = 3;

    while (scanner.hasNext()) {
      String currentLevel = scanner.nextLine();
      if (currentLevel.charAt(position) == '#') treeCounter++;
      position += 3;
      if (position > oneGridLength - 1) position = position % oneGridLength;
    }

    System.out.println("Nr of trees encountered: " + treeCounter);
    scanner.close();
  }
}
