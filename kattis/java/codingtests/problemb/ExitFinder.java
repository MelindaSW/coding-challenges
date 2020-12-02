package problemb;

import java.util.Scanner;

public class ExitFinder {
    private enum Direction {
        UP, DOWN, LEFT, RIGHT, DEFAULT
    }

    private static ExitFinder instance = null;

    private ExitFinder() {}

    public static ExitFinder getInstance() {
        if (instance == null)
            instance = new ExitFinder();
        return instance;
    }

    private PositionTracker tracker;

    public String[][] convertRoomInputToMatrix(Scanner scanner, int width, int length) {
        String[][] roomMatrix = new String[length][];
        for (int i = 0; i < roomMatrix.length; i++) {
            roomMatrix[i] = new String[width];
            roomMatrix[i] = scanner.nextLine().split("");
        }
        return roomMatrix;
    }

    public void printFormattedHouseResult(String[][] result, int houseNr) {
        System.out.format("HOUSE %d\n", houseNr);
        for (String[] row : result) {
            for (String character : row) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    public String[][] getRoomMarkedWithExit(String[][] room, int width) {
        setInitalPositionTracker(room);
        Direction currentDirection = getInitialDirection(width);

        int currentY;
        int currentX;
        boolean exitFound = false;
        String ch = "";

        while (!exitFound) {
            currentY = tracker.getY();
            currentX = tracker.getX();

            if (currentDirection.equals(Direction.UP)) {
                tracker.setY(Math.max(tracker.getY() - 1, 0));
                ch = checkColumn(room, currentDirection);

            } else if (currentDirection.equals(Direction.DOWN)) {
                tracker.setY(tracker.getY() + 1);
                ch = checkColumn(room, currentDirection);

            } else if (currentDirection.equals(Direction.RIGHT)) {
                tracker.setX(tracker.getX() + 1);
                ch = checkRow(room[currentY], currentDirection);

            } else if (currentDirection.equals(Direction.LEFT)) {
                tracker.setX(Math.max(tracker.getX() - 1, 0));
                ch = checkRow(room[currentY], currentDirection);
            }

            currentDirection = getDirection(ch, currentY, currentX);

            if (ch.equals("x")) exitFound = true;
        }
        room[tracker.getY()][tracker.getX()] = "&";
        return room;
    }

    private void setInitalPositionTracker(String[][] room) {
//      Find the entrance index and initialize tracker
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j].equals("*")) {
                    tracker = new PositionTracker(i, j);
                }
            }
        }
    }

    private Direction getInitialDirection(int width) {
        // Check where the entrance is placed and return initial direction.
        // bottom = UP, top = DOWN, right = LEFT, left = RIGHT
        if (tracker.getX() == 0) {
            return Direction.RIGHT;
        } else if (tracker.getX() == width) {
            return Direction.LEFT;
        } else if (tracker.getY() == 0) {
            return Direction.DOWN;
        } else {
            return Direction.UP;
        }
    }

    private String checkRow(String[] row, Direction direction) {
        if (direction.equals(Direction.LEFT)) { // [][-]
            for (int i = tracker.getX(); i >= 0; i--) {
                tracker.setX(i);
                if (checkCharacter(row[i])) {
                    return row[i];
                }
            }
        }
        if (direction.equals(Direction.RIGHT)) { // [][+]
            for (int i = tracker.getX(); i < row.length; i++) {
                tracker.setX(i);
                if (checkCharacter(row[i])) {
                    return row[i];
                }
            }
        }
        return "";
    }

    private String checkColumn(String[][] room, Direction direction) {
        if (direction.equals(Direction.UP)) { // [-][]
            for (int i = tracker.getY(); i >= 0; i--) {
                tracker.setY(i);
                if (checkCharacter(room[i][tracker.getX()])) {
                    return room[i][tracker.getX()];
                }
            }
        } else if (direction.equals(Direction.DOWN)) { // [+][]
            for (int i = tracker.getY(); i < room.length; i++) {
                tracker.setY(i);
                if (checkCharacter(room[i][tracker.getX()])) {
                    return room[i][tracker.getX()];
                }
            }
        }
        return "";
    }

    private boolean checkCharacter(String c) {
        return c.equals("/") || c.equals("\\") || c.equals("x");
    }

    private Direction getDirection(String character, int oldY, int oldX) {
        switch (character) {
            case "/":
                if (oldX < tracker.getX()) {
                    return Direction.UP;
                } else if (oldX > tracker.getX()) {
                    return Direction.DOWN;
                } else if (oldY > tracker.getY()) {
                    return Direction.RIGHT;
                } else if (oldY < tracker.getY()) {
                    return Direction.LEFT;
                }
                break;
            case "\\":
                if (oldX < tracker.getX()) {
                    return Direction.DOWN;
                } else if (oldX > tracker.getX()) {
                    return Direction.UP;
                } else if (oldY > tracker.getY()) {
                    return Direction.LEFT;
                } else if (oldY < tracker.getY()) {
                    return Direction.RIGHT;
                }
        }
        return Direction.DEFAULT;
    }
}