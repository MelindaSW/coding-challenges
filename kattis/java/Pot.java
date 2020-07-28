// https://open.kattis.com/problems/pot
import java.util.Scanner;

public class Pot {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int nrOfValues = Integer.parseInt(scanner.nextLine());
    int result = 0;
    for (int i = 0; i < nrOfValues; i++) {
      String value = scanner.nextLine();
      double nrToAdd = Double.parseDouble(value.substring(0, value.length() - 1));
      double pow =  Double.parseDouble(value.substring(value.length() - 1));
      result += Math.pow(nrToAdd, pow);
    }
    System.out.println(result);
  }
}
