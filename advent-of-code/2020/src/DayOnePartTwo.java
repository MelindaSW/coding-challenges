import java.io.File;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DayOnePartTwo {
    public static void main(String[] args) {
        // Find the three entries that sum to 2020 and multiply them with eachother to get the answer

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
        // Using Two pointer technique - the array must be sorted before traversal
        inputs.sort(Comparator.comparingInt(v -> v));
        int firstElement, lastElement;
        int expectedSum = 2020;
        for (int i = 0; i < inputs.size() - 2; i++) {
            firstElement = i + 1;
            lastElement = inputs.size() - 1;
            while (firstElement < lastElement) {
                int sum = inputs.get(i) + inputs.get(firstElement) + inputs.get(lastElement);
                if (sum == expectedSum) {
                    return inputs.get(i) * inputs.get(firstElement) * inputs.get(lastElement);
                } else if (sum < expectedSum) {
                    firstElement++;
                } else {
                    lastElement--;
                }
            }
        }
        return 0;
    }
}
