import java.util.Scanner;

public class R2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] input = scanner.nextLine().split(" ");
    int R1 = Integer.parseInt(input[0]);
    int S = Integer.parseInt(input[1]);
    int R2 = S * 2 - R1;
    System.out.println(R2);
    scanner.close();
  }
}
