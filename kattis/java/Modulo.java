import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Modulo {
  public static void main(String[] args) {
    // For each row of input do input modulo 42. Add the result to a set. When done print the lenght of the set.

      Scanner scanner = new Scanner(System.in);
      int counter = 0;
      Set<Integer> results = new HashSet<>();

      while (counter < 10) {
          int input = Integer.parseInt(scanner.nextLine());
          int nr = input % 42;
          results.add(nr);
          counter++;
      }

    System.out.println(results.size());
  }
}
