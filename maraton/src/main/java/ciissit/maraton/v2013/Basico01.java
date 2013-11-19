package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Solución a Stríngulos
 * 
 * @author Martín Canaval
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
                            line.substring(i, line.length()));
                }
            }
        } while(line != null && !line.isEmpty());
    }
    
    /**
     * Recibe una cadena str y retorna dicha cadena repetida n veces.
     * 
     * @param str es al cadena que deseamos repetir.
     * @param n el número de veces que deseamos que se repita.
     */
    private String replicate(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
