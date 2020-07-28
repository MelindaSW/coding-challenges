//https://open.kattis.com/problems/carrots
import java.util.Scanner;

public class Carrots {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split(" ");

    int nrOfContestants = Integer.parseInt(input[0]);
    int nrOfProbelmsSolved = Integer.parseInt(input[1]);

    for (int i = 0; i < nrOfContestants; i++) {
      scanner.nextLine();
    }

    System.out.println(nrOfProbelmsSolved);

  }
}
