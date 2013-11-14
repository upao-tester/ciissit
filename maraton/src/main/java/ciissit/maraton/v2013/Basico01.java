package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author martin
 */
public class Basico01 extends Template {

    public static void main(String[] args) {
        new Basico01().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        String line;
        int count = 0;
        do {
            line = jin.readLine();
            if(line != null && !line.isEmpty()) {
                count++;
                jout.printf("Caso %d:\n", count);
                for (int i = line.length() - 1; i >= 0; i--) {
                    jout.printf("%s%s\n", replicate(" ", i),
                            line.subSequence(i, line.length()));
                }
            }
        } while(line != null && !line.isEmpty());
    }
    
    private String replicate(String str, int veces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
