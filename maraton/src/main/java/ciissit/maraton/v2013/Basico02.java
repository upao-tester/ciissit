package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Martín Canaval
 */
public class Basico02 extends Template {

    public static void main(String[] args) {
        new Basico02().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        String line;
        String[] time;
        int h, m, s;
        String binH, binM, binS;
        int count = 0;
        do {
            line = jin.readLine();
            if(line != null && !line.isEmpty()) {
                count++;
                jout.printf("Caso %d:\n", count);
                time = line.split(" ");
                h = Integer.parseInt(time[0]);
                m = Integer.parseInt(time[1]);
                s = Integer.parseInt(time[2]);
                if(h > 23 || h < 0 || m > 59 || m < 0 || s > 59 || s < 0) {
                    jout.println("hora incorrecta");
                } else {
                    binH = toBinary6(h);
                    binM = toBinary6(m);
                    binS = toBinary6(s);
                    for (int i = 0; i < 6; i++) {
                        jout.printf("%s %s %s\n", 
                                binH.charAt(i),
                                binM.charAt(i),
                                binS.charAt(i));
                    }
                }
            }
        } while(line != null && !line.isEmpty());
    }
    
    private String toBinary6(int n) {
        return String.format("%6s", Integer.toBinaryString(n))
                .replace(' ', '0');
    }
}
