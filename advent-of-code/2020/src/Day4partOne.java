import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4partOne {
  public static void main(String[] args) throws FileNotFoundException {
    String filePath =
        "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day4.txt";
    String sampleFilePath =
        "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\SampleInput-Day4.txt"; // 2 valid passports

    Scanner scanner = new Scanner(new File(sampleFilePath));
    int nrOfValidPasswords = 0;

//    while (scanner.hasNext()) {
//      String line = scanner.nextLine();
//      System.out.println(line);
//      if (line.equals("")) break;
//    }
    scanner.close();
  }

  static boolean containsAllValidFields() {
    return true;
  }
}
