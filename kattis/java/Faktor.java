import java.util.Scanner;

public class Faktor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int nrOfArticles = Integer.parseInt(input[0]);
        int impact = Integer.parseInt(input[1]);
        int citations = ((impact - 1) * nrOfArticles) + 1;

        System.out.println(citations);
        scanner.close();
    }
}
