package ciissit.maraton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín Canaval
 */
public abstract class Template {

    private static final Logger l = Logger.getLogger(Template.class.getName());
    
    protected void init(String[] args) {
        BufferedReader jin;
        PrintStream jout;
        try {
            if (args.length == 2) {
                jin = new BufferedReader(new InputStreamReader(
                        new FileInputStream(args[0])));
                jout = new PrintStream(args[1], "UTF-8");
            } else {
                // TODO usar filechooser para modo de prueba
                jin = new BufferedReader(new InputStreamReader(System.in));
                jout = System.out;
                l.log(Level.WARNING, "Por favor configurar entrada y salida!");
                l.log(Level.WARNING, "Usando entrada y salida estándar.");
            }
            start(jin, jout);
            jin.close();
            jout.close();
        } catch (FileNotFoundException ex) {
            l.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            l.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * La implementación de este método debe contener la solución a un problema
     * 
     * @param jin
     * @param jout
     * @throws IOException
     */
    public abstract void start(BufferedReader jin, PrintStream jout) throws IOException;
}
