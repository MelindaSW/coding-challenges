//https://open.kattis.com/problems/grassseed

import java.util.Scanner;

public class GrassSeedInc {

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double seedCost = Double.parseDouble(scanner.nextLine());
      int nrOfLawns = Integer.parseInt(scanner.nextLine());
      double lawnSize = 0.0;
      for (int i = 0; i < nrOfLawns; i++) {
          String[] measurements = scanner.nextLine().split(" ");
          double width = Double.parseDouble(measurements[0]);
          double length = Double.parseDouble(measurements[1]);
          lawnSize += width * length;
      }
      double totalCost = seedCost * lawnSize;
      System.out.format("%.7f",totalCost);
      scanner.close();
  }
}
