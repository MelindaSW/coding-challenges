// https://open.kattis.com/problems/pieceofcake2

import java.util.Arrays;
import java.util.Scanner;

public class PieceOfCake {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cakeSide = scanner.nextInt();
    int horizontalCut = scanner.nextInt();
    int verticalCut = scanner.nextInt();
    int height = 4;

    int cutOne = horizontalCut * verticalCut * height;
    int cutTwo = (cakeSide - horizontalCut) * verticalCut * height;
    int cutThree = (cakeSide - verticalCut) * horizontalCut * height;
    int cutFour = (cakeSide - horizontalCut) * (cakeSide - verticalCut) * height;

    int[] cuts = Arrays.stream(new int[] {cutOne, cutTwo, cutThree, cutFour}).sorted().toArray();
    int largestSliceVolume = cuts[cuts.length - 1];
    System.out.println(largestSliceVolume);
    scanner.close();
  }
}
