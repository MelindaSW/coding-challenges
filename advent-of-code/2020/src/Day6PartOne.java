import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day6PartOne {
  public static void main(String[] args) throws IOException {
    String filePath =
        "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day6.txt";
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String currentLine = "";
    StringBuilder sb = new StringBuilder();
    List<Integer> allGroupsAnswers = new ArrayList<>();

    while ((currentLine = reader.readLine()) != null) {
      sb.append(currentLine);
      if (currentLine.equals("")) {
        allGroupsAnswers.add(countDistinctYesAnswers(sb.toString()));
        sb.delete(0, sb.length());
      }
    }
    System.out.println(sumOfAllYesQuestions(allGroupsAnswers));
    reader.close();
  }

  static int countDistinctYesAnswers(String answers) {
    Set<String> distinctAnswers = Arrays.stream(answers.split("")).collect(Collectors.toSet());
    return distinctAnswers.size();
  }

  static int sumOfAllYesQuestions(List<Integer> answers) {
    int sum = 0;
    for (Integer x : answers) {
      sum += x;
    }
    return sum;
  }
}
