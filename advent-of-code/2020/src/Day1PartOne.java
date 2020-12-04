import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day1PartOne {

  public static void main(String[] args) {
    List<Integer> inputs = new LinkedList<>();
    try {
      Scanner scanner =
          new Scanner(
              new File(
                  "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day1.txt"));
      while (scanner.hasNext()) {
        inputs.add(Integer.parseInt(scanner.nextLine()));
      }
      scanner.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(findProductOfEntriesAddingUpTo2020(inputs));
  }

  static int findProductOfEntriesAddingUpTo2020(List<Integer> inputs) {
    for (Integer input : inputs) {
      for (int i = 0; i < inputs.size(); i++) {
        if (inputs.indexOf(input) != i) {
          if (input + inputs.get(i) == 2020) return input * inputs.get(i);
        }
      }
    }
    return 0;
  }
}
