package capgemini;

import java.util.Scanner;

public class ProblemAMain {

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int nrOfTestCases = Integer.parseInt(scanner.nextLine());
      for (int i = 0; i < nrOfTestCases; i++) {
          int value = Integer.parseInt(scanner.nextLine());
          System.out.println(isOddOrEven(value));
      }
      scanner.close();
  }

   static String isOddOrEven(int value) {
      return value % 2 == 0 ? value + " is even" : value + " is odd";
  }
}
