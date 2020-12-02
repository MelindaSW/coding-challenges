import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DayTwoPartOne {
  public static void main(String[] args) {
      int validPasswords = 0;

      try {
        Scanner scanner = new Scanner(new File("C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-DayTwo.txt"));

        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(" ");
            String[] minMax = input[0].split("-");
            int min = Integer.parseInt(minMax[0]);
            int max = Integer.parseInt(minMax[1]);
            String letter = input[1].substring(0,1);
            String password = input[2];
            List<String> letters = Arrays.stream(password.split("")).filter(s -> s.equals(letter)).collect(Collectors.toList());
            if (letters.size() >= min && letters.size() <= max) validPasswords++;
      }

        scanner.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
      System.out.println(validPasswords);
  }
}

