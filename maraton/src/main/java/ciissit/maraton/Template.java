package ciissit.maraton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Martín Canaval
 */
public abstract class Template {

    private static final Logger l = Logger.getLogger(Template.class.getName());

    protected void init(String[] args) {
        try {
            BufferedReader jin;
            PrintStream jout;
            String inFileName = null;
            String outFileName = null;

            if (args.length == 2) {
                l.log(Level.INFO, "Entrada y salida correctamente declaradas!");
                inFileName = args[0];
                outFileName = args[1];
            } else {
                l.log(Level.WARNING, "Estableciendo entrada y salida!");
                // Modo Testing
                JFileChooser fs = new JFileChooser();
                int resp = fs.showOpenDialog(null);
                if (resp == JFileChooser.APPROVE_OPTION) {
                    inFileName = fs.getSelectedFile().getPath();
                    outFileName = inFileName.replaceAll("\\..*$", "") + ".out";
                    l.log(Level.INFO, "Salida: {0}", outFileName);
                }
            }
            if (inFileName != null && outFileName != null) {
                jin = new BufferedReader(new InputStreamReader(
                        new FileInputStream(inFileName)));
                jout = new PrintStream(outFileName, "UTF-8");
            } else {
                l.log(Level.WARNING, "Usando entrada y salida estándar.");
                jin = new BufferedReader(new InputStreamReader(System.in));
                jout = System.out;
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
    public abstract void start(BufferedReader jin, PrintStream jout)
            throws IOException;
}
