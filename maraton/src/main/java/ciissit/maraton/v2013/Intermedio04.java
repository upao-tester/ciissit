package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Stack;

/**
 *
 * @author Martín Canaval
 */
public class Intermedio04 extends Template {

    public static void main(String[] args) {
        new Intermedio04().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        String bfProgram;
        int count = 0;

        do {
            bfProgram = jin.readLine();
            if (bfProgram != null && !bfProgram.isEmpty()) {
                count++;
                jout.printf("Caso %d: ", count);
                parseBF(bfProgram, null, jout);
                jout.println();
            }
        } while (bfProgram != null && !bfProgram.isEmpty());
    }
    
    private void parseBF(String program, BufferedReader jin, PrintStream jout)
            throws IOException {
        int[] data = new int[3000];
        int dataPointer = 0;
        int commandPointer = 0;
        char command;
        Stack<Integer> bracketPointers = new Stack<Integer>();

        while (commandPointer < program.length()) {
            command = program.charAt(commandPointer);
            switch (command) {
                case '+':
                    data[dataPointer]++;
                    break;
                case '-':
                    data[dataPointer]--;
                    break;
                case '.':
                    jout.print((char)data[dataPointer]);
                    break;
                case ',':
                    data[dataPointer] = jin.read();
                    break;
                case '>':
                    dataPointer++;
                    break;
                case '<':
                    dataPointer--;
                    break;
                case '[':
                    if (data[dataPointer] == 0) {
                        commandPointer = program.indexOf(commandPointer, ']');
                    } else {
                        bracketPointers.push(commandPointer);
                    }
                    break;
                case ']':
                    if (data[dataPointer] == 0) {
                        bracketPointers.pop();
                    } else {
                        commandPointer = bracketPointers.peek();
                    }
                    break;
            }
            commandPointer++;
        }
    }
}
