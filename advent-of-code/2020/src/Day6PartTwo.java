import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day6PartTwo {
  public static void main(String[] args) throws IOException {
    String filePath =
        "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day6.txt";
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String currentLine = "";
    List<Integer> allGroupsAnswers = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int nrOfPeopleInGroup = 0;

    while ((currentLine = reader.readLine()) != null) {
      sb.append(currentLine);
      nrOfPeopleInGroup += 1;
      if (currentLine.equals("")) {
        allGroupsAnswers.add(countAnswers(sb.toString(), nrOfPeopleInGroup - 1));
        sb.delete(0, sb.length());
        nrOfPeopleInGroup = 0;
      }
    }

    System.out.println(sumOfAllGroupsAnswers(allGroupsAnswers));
    reader.close();
  }

  static int countAnswers(String answers, int nrOfPeopleInGroup) {
    AtomicInteger sum = new AtomicInteger();
    Arrays.stream(answers.split(""))
        .collect(Collectors.groupingBy(s -> s))
        .forEach(
            (k, v) -> {
              if (v.size() == nrOfPeopleInGroup) sum.getAndIncrement();
            });

    return sum.get();
  }

  static int sumOfAllGroupsAnswers(List<Integer> answers) {
    int sum = 0;
    for (Integer x : answers) {
      sum += x;
    }
    return sum;
  }
}
