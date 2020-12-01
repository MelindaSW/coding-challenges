import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DayOnePartOne {

    public static void main(String[] args) {
    // Find the two entries that sum to 2020 and multiply them with eachother to get the answer

    List<Integer> inputs = new LinkedList<>();
    try {
      Scanner scanner =
          new Scanner(
              new File(
                  "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-DayOne.txt"));
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