package melindas;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        System.out.println("Skriv in ditt namn");
        Scanner sc = new Scanner(System.in);

        String name= sc.nextLine();

        if(name.equalsIgnoreCase("Sofia")) {
            System.out.println("Hej " + name);
        } else {
            System.out.println("Du är inte Sofia!");
        }
    }
}
