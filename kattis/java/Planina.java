//https://open.kattis.com/problems/planina
import java.util.Scanner;

public class Planina {
  public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      int iterations = scanner.nextInt();
      scanner.close();

      int nrOfSidePoints = 2;
      for (int i = 0; i < iterations; i++) {
          nrOfSidePoints += (nrOfSidePoints - 1);
      }
      int result = nrOfSidePoints * nrOfSidePoints;
      System.out.println(result);
  }
}
