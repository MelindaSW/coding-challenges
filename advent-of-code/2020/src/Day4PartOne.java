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
    int nrOfValidPassports = 0;

    while (scanner.hasNext()) {
      String passport = readPassport(scanner);
      System.out.println(passport);
      if (validatePassport(passport)) nrOfValidPassports++;
    }
    System.out.println(nrOfValidPassports);
    scanner.close();
  }

  static String readPassport(Scanner scanner) {
    StringBuilder passport = new StringBuilder();
    while (true) {
      String line = scanner.hasNextLine() ? scanner.nextLine() : "";
      if (line.equals("")) {
        return passport.toString();
      }
      passport.append(line).append(" ");
    }
  }

  static boolean validatePassport(String password) {
    String[] expectedFields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    Map<String, String> fields = passportFieldsToHashMap(password);
    boolean isValid = true;
    for (String expectedField : expectedFields) {
      if (!fields.containsKey(expectedField)) {
        isValid = false;
        break;
      }
    }
    return isValid;
  }

  static Map<String, String> passportFieldsToHashMap(String password) {
    Map<String, String> passportFields = new HashMap<>();
    String[] pwd = password.split(" ");
    for (String field : pwd) {
      String[] keyValue = field.split(":");
      passportFields.put(keyValue[0], keyValue[1]);
    }
    return passportFields;
  }
}
