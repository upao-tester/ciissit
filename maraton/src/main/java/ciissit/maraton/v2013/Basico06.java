package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Martín Canaval
 */
public class Basico06 extends Template {

    public static void main(String[] args) {
        new Basico06().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        String data;
        ArrayList<String> lines = new ArrayList<String>();
        HashSet<Character> orderedChars = new HashSet<Character>();
        int lim = 0;

        do {
            data = jin.readLine();
            if (data != null && !data.isEmpty()) {
                lines.add(data);
                if(data.length() > lim) {
                    lim = data.length();
                }
            }
        } while (data != null && !data.isEmpty());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lim; i++) {
            for (String line : lines) {
                if (i < line.length()) {
                    if (orderedChars.add(line.charAt(i))) {
                        sb.append(line.charAt(i));
                    }
                }
            }
        }
        jout.println(sb.toString());
    }
}
