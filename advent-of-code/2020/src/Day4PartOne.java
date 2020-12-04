import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4PartOne {
  public static void main(String[] args) throws FileNotFoundException {
    String filePath =
        "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day4.txt";
    Scanner scanner = new Scanner(new File(filePath));
    int nrOfValidPasswords = 0;

    while (scanner.hasNext()) {
      String password = readPassword(scanner);
      System.out.println(password);
      if (validatePassword(password)) nrOfValidPasswords++;
    }
    System.out.println(nrOfValidPasswords);
    scanner.close();
  }

  static String readPassword(Scanner scanner) {
    StringBuilder password = new StringBuilder();
    while (true) {
      String line = scanner.hasNextLine() ? scanner.nextLine() : "";
      if (line.equals("")) {
        return password.toString();
      }
      password.append(line).append(" ");
    }
  }

  static boolean validatePassword(String password) {
    String[] expectedFields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    Map<String, String> fields = mapPasswordFields(password);
    boolean isValid = true;
    for (String expectedField : expectedFields) {
      if (!fields.containsKey(expectedField)) {
        isValid = false;
        break;
      }
    }
    return isValid;
  }

  static Map<String, String> mapPasswordFields(String password) {
    Map<String, String> passwordFields = new HashMap<>();
    String[] pwd = password.split(" ");
    for (String field : pwd) {
      String[] keyValue = field.split(":");
      passwordFields.put(keyValue[0], keyValue[1]);
    }
    return passwordFields;
  }
}
