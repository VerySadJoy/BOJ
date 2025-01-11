//Question No: 2733
//Title: Brainf*ck
//Tier: Gold III
import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int testCases;
    static int[] memory;
    static int pointer;
    static String instructions;
    static int instructionIndex;
    static HashMap<Integer, Integer> brackets;

    static void incrementPointer() {
        pointer = (pointer == 32767) ? 0 : pointer + 1;
    }

    static void decrementPointer() {
        pointer = (pointer == 0) ? 32767 : pointer - 1;
    }

    static void incrementValue() {
        memory[pointer] = (memory[pointer] == 255) ? 0 : memory[pointer] + 1;
    }

    static void decrementValue() {
        memory[pointer] = (memory[pointer] == 0) ? 255 : memory[pointer] - 1;
    }

    static void outputValue() throws IOException {
        writer.write((char) memory[pointer]);
    }

    static void handleOpeningBracket() {
        if (memory[pointer] == 0) {
            instructionIndex = brackets.get(instructionIndex);
        }
    }

    static void handleClosingBracket() {
        if (memory[pointer] != 0) {
            instructionIndex = brackets.get(instructionIndex);
        }
    }

    static boolean validateInstructions() {
        brackets = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < instructions.length(); i++) {
            char command = instructions.charAt(i);
            if (command == '[') {
                stack.push(i);
            } else if (command == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                int openingBracketIndex = stack.pop();
                brackets.put(openingBracketIndex, i);
                brackets.put(i, openingBracketIndex);
            }
        }

        return stack.isEmpty();
    }

    static void skipComment() {
        while (instructions.charAt(instructionIndex) != 'N') {
            instructionIndex++;
        }
    }

    static void executeBrainfuck() throws IOException {
        StringBuilder instructionBuilder = new StringBuilder();
        String line;

        while (!(line = reader.readLine()).equals("end")) {
            instructionBuilder.append(line).append("N");
        }

        instructions = instructionBuilder.toString();

        if (!validateInstructions()) {
            writer.write("COMPILE ERROR");
            return;
        }

        for (instructionIndex = 0; instructionIndex < instructions.length(); instructionIndex++) {
            char command = instructions.charAt(instructionIndex);
            switch (command) {
                case '>' -> incrementPointer();
                case '<' -> decrementPointer();
                case '+' -> incrementValue();
                case '-' -> decrementValue();
                case '.' -> outputValue();
                case '[' -> handleOpeningBracket();
                case ']' -> handleClosingBracket();
                case '%' -> skipComment();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            memory = new int[32768];
            pointer = 0;
            writer.write("PROGRAM #" + i + ":\n");
            executeBrainfuck();
            writer.write('\n');
        }

        writer.flush();
    }
}