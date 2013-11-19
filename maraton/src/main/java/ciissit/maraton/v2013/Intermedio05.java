package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Solición a Old Magician
 * 
 * @author Martín Canaval
 */
public class Intermedio05 extends Template {

    public static void main(String[] args) {
        new Intermedio05().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        String[] data;
        String resp;
        int b, w, count;
        int m = Integer.parseInt(jin.readLine());
        count = 0;
        for (int i = 0; i < m; i++) {
            data = jin.readLine().split(" ");
            w = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
            if(b % 2 == 0) {
                resp = "Blanco";
            } else {
                resp = "Negro";
            }
            count++;
            jout.printf("Caso #%d: %s\n", count, resp);
        }
    }
}

/*
Explicación:
Si el número de pelotitas neglas es impar, la última bolita restante es negra.
Caso contrario, es blanca.

 */
