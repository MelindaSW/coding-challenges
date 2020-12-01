package capgemini;

import java.util.*;
import java.util.stream.Collectors;

public class ProblemCMain {
  public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      int amountOfDishesAndPersons = Integer.parseInt(scanner.nextLine());
      int seconds = 0;

      for (int i = 0; i < amountOfDishesAndPersons; i++) {
          String[] assignment = scanner.nextLine().split(" ");
          LinkedList<Integer> dietRestrictions = (LinkedList<Integer>) Arrays.stream(assignment).map(Integer::parseInt).collect(Collectors.toList());
          int dietAmount = dietRestrictions.pop();
          
      }


      System.out.println(seconds % 1000000009);
      scanner.close();
  }



}



//    static int[] getSeconds(List<Integer> table, int assignment, int person) {
//        // Return the amount of seconds it takes for a person to get an assignment when "spinning" the table clockwise and counterclockwise.
//        // Find out the index of the dish in the table list.
//        // Compare it to the index of the person and return the difference of either side. Return both differences.
//        int[] seconds = {0, 0};
//        return seconds;
//    }

//      for (int i = 0; i < amountOfSets; i++) {
//          List<Integer> currentAssignment = new LinkedList<>();
//          String[] input = scanner.nextLine().split(" ");
//          for (String s : input) {
//              currentAssignment.add(Integer.parseInt(s));
//          }
//          diets.add(currentAssignment);
//      }