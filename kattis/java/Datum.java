import java.time.LocalDate;
import java.util.Scanner;
// https://open.kattis.com/problems/datum

public class Datum {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int day = scanner.nextInt();
    int month = scanner.nextInt();
    LocalDate date = LocalDate.of(2009, month, day);
    System.out.println(date.getDayOfWeek());
    scanner.close();
  }
}
