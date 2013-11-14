package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author martin
 */
public class Basico03 extends Template {

    public static void main(String[] args) {
        new Basico03().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        String line;
        String[] data;
        int a, b, m, suma;
        int count = 0;
        do {
            line = jin.readLine();
            if(line != null && !line.isEmpty()) {
                data = line.split(" ");
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
                m = Integer.parseInt(data[2]);
                if(a > 0 && b > 0 && m > 0) {
                    suma = 0;
                    for (int i = 0; i < m; i++) {
                        if(i % a == 0 || i % b == 0) {
                            suma += i;
                        }
                    }
                    count++;
                    jout.printf("Caso %d: %d\n", count, suma);    
                }
            }
        } while(line != null && !line.isEmpty());
    }
}
