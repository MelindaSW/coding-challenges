package com.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DayTwo {

    public static void main(String[] args) {

        final String FILE_PATH = "C:\\Users\\sands\\Documents\\Projects\\advent-of-code\\day2-puzzle-input.txt";

        List<Integer> inputs = readAndAddInputsFromFile(FILE_PATH);

        int noun = 0;
        int verb = 0;
        int output = 0;

        for (noun = 0; noun < 99; noun++) {

            for (verb = 0; verb < 99; verb++) {
                setNounAndVerb(inputs, noun, verb);
                output = runProgramAndReturnResult(inputs);
                if (output == -1) {
                    System.out.println(":(");
                } else if ( output == 19690720){
                    System.out.println("Output = " + output + "Noun = " + noun + " Verb = " + verb);
                    break;
                }
            }
            if (output == 19690720) {
                break;
            }
        }

        System.out.println("Answer: " + 100 * noun + verb);


    }

    public static List<Integer> readAndAddInputsFromFile(String pathName) {
        List<Integer> inputs = new ArrayList<Integer>();
        Scanner s = null;
        int result = 0;
        try {
            s = new Scanner(new File(pathName));
            s.useDelimiter(",");
            while (s.hasNext()) {
                inputs.add(s.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return inputs;
    }

    public static void resetInputList(List<Integer> alteredInputs, List<Integer> originalInputs) {
        alteredInputs.clear();
        alteredInputs.addAll(originalInputs);
    }

    public static void setNounAndVerb(List<Integer> inputs, int noun, int verb) {
        inputs.set(1, noun);
        inputs.set(2, verb);
    }

    public static int runProgramAndReturnResult(List<Integer> inputs) {
        boolean runProgram = true;
        int index = 0;
        int opCode = inputs.get(0);

        try {
            while (!runProgram) {
                int paramValueOne = inputs.get(inputs.get(index + 1));
                int paramValueTwo = inputs.get(inputs.get(index + 2));
                int overWritePositionParam = inputs.get(index + 3);

                switch (opCode) {
                    case 1:
                        inputs.set(overWritePositionParam, paramValueOne + paramValueTwo);
                        break;
                    case 2:
                        inputs.set(overWritePositionParam, paramValueOne * paramValueTwo);
                        break;
                    case 99:
                        runProgram = true;
                        break;
                    default:
                        System.out.println("Something weird went wrong");
                        break;
                }
                index = index + 4;
                opCode = inputs.get(index);
            }
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }

        if (inputs.get(0) == 19690720) {
            return inputs.get(0);
        } else {
            return -1;
        }

    }


}






        /*

                    while (!runProgram) {
                valueOne = inputs.get(inputs.get(index + 1));
                valueTwo = inputs.get(inputs.get(index + 2));
                newPosition = inputs.get(index + 3);
                switch (opCode) {
                    case 1:
                        inputs.set(newPosition, valueOne + valueTwo);
                        break;
                    case 2:
                        inputs.set(newPosition, valueOne * valueTwo);
                        break;
                    case 99:
                        runProgram = true;
                        break;
                    default:
                        System.out.println("Something went wrong");
                        break;
                }
                index = index + 4;
                opCode = inputs.get(index);
            }
                Before:
        Replace position 1 with value 12.
        Replace position 2 with value 2.

        1: Read list of ints into an arraylist
        2: Look att position 0
        3: Read the Opcode. Do what it tells you
        4: Move forward 4 steps.

        Return the value of position 0 when program halts.

        OpCodes:

        99 = halts the program

        1 =
        add together numbers from two positions in the list.
        Position 1: 1st nr after opCode,
        Position 2: 2nd nr after opCode.
        Position 3: Where the result of the calculation of pos 1 and 2 should be stored.

        2 = Do like opCode one but multiply instead of adding the position 1 and 2 values.

        variables: opCode

        * */

