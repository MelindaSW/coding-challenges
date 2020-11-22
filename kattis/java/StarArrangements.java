import java.util.Scanner;
    // https://open.kattis.com/problems/stararrangements

public class StarArrangements {
  public static void main(String[] args) {
          Scanner scanner= new Scanner(System.in);
          int nrOfStars = scanner.nextInt();
          scanner.close();
    StringBuilder stringBuilder = new StringBuilder(nrOfStars + ":\n");

    // starting with 2 stars in first row, flag with only one star rows are not asked for.
    for (int i = 2; i < (nrOfStars/2); i++) {
    }

    System.out.println(50%25);
    System.out.println(50 % 4);
    System.out.println(50 % 13);
    System.out.println(50 / 13);
  }
}
