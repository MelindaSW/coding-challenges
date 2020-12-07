import java.util.Scanner;

public class QualityOfLife {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int nrOfPeriods = Integer.parseInt(scanner.nextLine());
    double qualy = 0.0;
    for (int i = 0; i < nrOfPeriods; i++) {
      String[] input = scanner.nextLine().split(" ");
      Double quality = Double.parseDouble(input[0]);
      Double years = Double.parseDouble(input[1]);
      qualy += quality * years;
    }
    System.out.println(qualy);
    scanner.close();
  }
}
