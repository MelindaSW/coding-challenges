import java.io.File;
import java.util.Scanner;

public class DayTwoPartTwo {
    public static void main(String[] args) {
        int validPasswords = 0;

        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-DayTwo.txt"));

            while (scanner.hasNext()) {
                String[] input = scanner.nextLine().split(" ");
                String[] minMax = input[0].split("-");
                int posOne = Integer.parseInt(minMax[0]);
                int posTwo = Integer.parseInt(minMax[1]);
                String letter = input[1].substring(0,1);
                String password = input[2];
                String first = password.substring(posOne - 1, posOne);
                String second = password.substring(posTwo - 1, posTwo);

                if (first.equals(letter) || second.equals(letter)) {
                    if (!first.equals(second)) validPasswords++;
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(validPasswords);
    }
}
