import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7PartOne {

  static List<String> rules = new ArrayList<>();
  static Set<String> bagsContainingShinyGold = new HashSet<>();
  //  static Set<String> bagsContainingNoBags = new HashSet<>();

  public static void main(String[] args) throws IOException {
    String filePath =
        "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-Day7.txt";
    BufferedReader reader = new BufferedReader(new FileReader(filePath));

    String bagRule = "";

    while ((bagRule = reader.readLine()) != null) {
      findBagsContainsShinyGold(bagRule);
      rules.add(bagRule);
    }

    boolean allBagsFound = false;
    while (!allBagsFound) {
      int lastSize = bagsContainingShinyGold.size();
      for (String rule : rules) {
        findBagsContainingBagsContainingShinyGold(rule);
      }
      if (lastSize == bagsContainingShinyGold.size()) allBagsFound = true;
    }
    reader.close();
  }

  static void findBagsContainsShinyGold(String rule) {
    String outerBag = rule.split(" ")[0].concat(" " + rule.split(" ")[1]);
    String innerBags = rule.split("contain ")[1];
    Pattern p = Pattern.compile("shiny gold");
    Matcher bagMatcher = p.matcher(innerBags);
    long count = bagMatcher.results().count();
    if (count > 0) bagsContainingShinyGold.add(outerBag);
  }

  static void findBagsContainingBagsContainingShinyGold(String rule) {
    String outerBag = rule.split(" ")[0].concat(" " + rule.split(" ")[1]);
    String innerBags = rule.split("contain ")[1];

    for (String sgbag : bagsContainingShinyGold) {
      Pattern p = Pattern.compile(sgbag);
      Matcher bagMatcher = p.matcher(innerBags);
      if (bagMatcher.results().count() > 0) {
        bagsContainingShinyGold.add(outerBag);
        break;
      }
    }
  }
}
