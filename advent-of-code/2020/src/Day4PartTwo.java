import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4PartTwo {
  public static void main(String[] args) throws FileNotFoundException {
    String filePath =
        "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day4.txt";
    Scanner scanner = new Scanner(new File(filePath));

    int nrOfValidPassports = 0;
    String[] expectedFields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

    while (scanner.hasNext()) {
      String passport = readPassport(scanner);
      Map<String, String> fields = passportFieldsToHashMap(passport);
      if (validatePassportFields(fields, expectedFields) && validatePassportValues(fields))
        nrOfValidPassports++;
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

  static boolean validatePassportFields(Map<String, String> passport, String[] expectedFields) {
    boolean isValid = true;
    for (String expectedField : expectedFields) {
      if (!passport.containsKey(expectedField)) {
        isValid = false;
        break;
      }
    }
    return isValid;
  }

  static boolean validatePassportValues(Map<String, String> passport) {
    try {
      int byr = Integer.parseInt(passport.get("byr"));
      boolean byrIsValid = byr >= 1920 && byr <= 2002;

      int iyr = Integer.parseInt(passport.get("iyr"));
      boolean iyrIsValid = iyr >= 2010 && iyr <= 2020;

      int eyr = Integer.parseInt(passport.get("eyr"));
      boolean eyrisValid = eyr >= 2020 && eyr <= 2030;

      String hgt = passport.get("hgt");
      int height = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
      boolean hgtisValid =
          hgt.endsWith("in") && height >= 59 && height <= 76
              || hgt.endsWith("cm") && height >= 150 && height <= 193;

      boolean hclIsValid = passport.get("hcl").matches("#[a-f0-9]{6}");
      boolean eclisValid = passport.get("ecl").matches("amb|blu|brn|gry|grn|hzl|oth");
      boolean pidIsValid = passport.get("pid").matches("\\d{9}");

      return byrIsValid
          && iyrIsValid
          && eyrisValid
          && hgtisValid
          && hclIsValid
          && eclisValid
          && pidIsValid;

    } catch (NumberFormatException e) {
      return false;
    }
  }

  static Map<String, String> passportFieldsToHashMap(String passports) {
    Map<String, String> passportFields = new HashMap<>();
    String[] pwd = passports.split(" ");
    for (String field : pwd) {
      String[] keyValue = field.split(":");
      passportFields.put(keyValue[0], keyValue[1]);
    }
    return passportFields;
  }
}

//    byr (Birth Year) - four digits; at least 1920 and at most 2002.
//    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
//    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
//    hgt (Height) - a number followed by either cm or in:
//    If cm, the number must be at least 150 and at most 193.
//    If in, the number must be at least 59 and at most 76.
//    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
//    String validHcl = ;
//    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
//    pid (Passport ID) - a nine-digit number, including leading zeroes.