package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Solución a Rare Order
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
        // HashSet es una colección que no acepta elementos repetidos
        HashSet<Character> orderedChars = new HashSet<Character>();
        int lim = 0;

        // Agregamos todas las líneas en la entrada para procesarlas luego.
        do {
            data = jin.readLine();
            if (data != null && !data.isEmpty()) {
                lines.add(data);
                if(data.length() > lim) {
                    // registramos la longitud de la línea más grande.
                    lim = data.length();
                }
            }
        } while (data != null && !data.isEmpty());
        StringBuilder sb = new StringBuilder();
        // Recorremos columnas
        for (int i = 0; i < lim; i++) {
            // Recorremos cada línea
            for (String line : lines) {
                if (i < line.length()) {
                    // Si hay un caractér en la posición 'i' de la línea
                    if (orderedChars.add(line.charAt(i))) {
                        // agregamos dicho caracter a un buffer
                        sb.append(line.charAt(i));
                    }
                }
            }
        }
        jout.println(sb.toString());
    }
}

/*
Explicación:

Podemos considerar todo el texto de entrada como una matríz de 2 dimensiones
    1 2 3 4 
  +---------
1 | X W Y
2 | Z X
3 | Z X Y
4 | Z X W
5 | Y W W X

Ahora agregamos en us sólo arreglo sin repetir elementos la columna 1
obtenemos:
 X Z Y
Continuamos con la columna 2 agregando a nuestro arreglo anterior obtenemos:
 X Z Y W
X ya existía en nuestró arreglo, por lo tanto no lo agregamos.
Continuamos con la columna 3, obtenemos:
 X Z Y W
No agregamos nada ya que Y y W ya estaban agregados. Lo mismo ocurro con la 
columna 4.

El resultado final es lo que solicita el problema.
*/
