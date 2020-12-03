import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThreePartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\sands\\Documents\\Projects\\coding-challenges\\advent-of-code\\2020\\PuzzleInput-DayThree.txt";
        int[] positionsRight = {1, 3, 5, 7, 1};
        int[] down = {1, 1, 1, 1, 2};
        int[] treesPerSlope = new int[positionsRight.length];

        for (int i = 0; i < positionsRight.length; i++) {
            Scanner scanner = new Scanner(new File(filePath));
            String firstLine = scanner.nextLine();
            int oneGridLenght = firstLine.length();
            int treeCounter = 0;
            int levelsSlopedDown = 0;
            int position = positionsRight[i];
            int stepsDown = down[i];

            while (scanner.hasNext()) {
                String currentLevel = scanner.nextLine();
                levelsSlopedDown++;

                if (levelsSlopedDown == stepsDown) {
                    levelsSlopedDown = 0;

                    if (currentLevel.charAt(position) == '#') treeCounter++;

                    position += positionsRight[i];
                    if (position > oneGridLenght - 1) position = position % oneGridLenght;
                }
            }
            
            treesPerSlope[i] = treeCounter;
            scanner.close();
        }

        long productOfAllTrees = 1L;
        for (int trees : treesPerSlope) {
            productOfAllTrees *= trees;
        }
        System.out.println(productOfAllTrees);
    }
}

