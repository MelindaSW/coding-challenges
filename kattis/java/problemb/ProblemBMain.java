package problemb;

import java.util.Scanner;

public class ProblemBMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExitFinder exitFinder = ExitFinder.getInstance();

        int houseCount = 0;
        while (true) {
            try {
                String[] measurements = scanner.nextLine().split(" ");
                int width = Integer.parseInt(measurements[0]);
                int length = Integer.parseInt(measurements[1]);
                if (width == 0 && length == 0) break;

                houseCount += 1;
                String[][] room = exitFinder.convertRoomInputToMatrix(scanner, width, length);
                String[][] roomWithExit = exitFinder.getRoomMarkedWithExit(room, width -1);
                exitFinder.printFormattedHouseResult(roomWithExit, houseCount);

            } catch (NumberFormatException e) {
                System.out.println("Input not valid");
            }
        }

        scanner.close();
    }
}
