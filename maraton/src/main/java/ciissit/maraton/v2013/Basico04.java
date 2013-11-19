package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * Solición a Producto Escalar Mínimo
 * 
 * @author Martín Canaval
 */
public class Basico04 extends Template {

    public static void main(String[] args) {
        new Basico04().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        int t, n, prod;
        int[] v1, v2;

        t = Integer.parseInt(jin.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(jin.readLine());
            v1 = fromStrArraytoIntArray(jin.readLine().split(" "));
            v2 = fromStrArraytoIntArray(jin.readLine().split(" "));
            Arrays.sort(v2);
            Arrays.sort(v1);
            prod = 0;
            for (int j = 0; j < n; j++) {
                prod += v1[j] * v2[n - j - 1];
            }
            jout.printf("Caso %d: %d\n", (i + 1), prod);
        }
    }
    
    /**
     * Recibe un arreglo de cadenas de caractéres, transforma cada elemento
     * a entero y retorna el equivalente arreglo de enteros.
     * 
     * @param data el arreglo de cadenas a convertir a arreglo de enteros
     */
    private int[] fromStrArraytoIntArray(String[] data) {
        // TODO: Validar o lanzár excepción de tipo incorrecto.
        int[] vector = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            vector[i] = Integer.parseInt(data[i]);
        }
        return vector;
    }
}

/*
Explicación:

Para que el producto escalar sea el más pequeño posible, es necesario 
multiplicar el valor más grande de un vector con el más pequeño del otro,
luego el segundo más grande del primero con el segundo elemento más pequeño del
segundo y asi sucesivamente, por lo tanto vasta con ordenar los vectores
y múltiplicar cruzadamente: 
x1 * yn + x2 * yn-1 + x3 * yn-2 ... + xn * y1

Otra posibilidad es ordenar el primer vector ascendentemente y el segundo
descendentemente y luego realizar un producto escalar normal.
*/