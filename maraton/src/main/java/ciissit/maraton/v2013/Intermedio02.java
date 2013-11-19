package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martín Canaval
 */
public class Intermedio02 extends Template {

    public static void main(String[] args) {
        new Intermedio02().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        int count = 0, degree;
        double[] coefficient, temp;
        double xLow, xHigh, mark, prev, prevHigh, prevLow;
        int inc, cMarks;
        double volume, tempVol;
        String line, sep;

        do {
            line = jin.readLine();
            if (line != null && !line.isEmpty()) {
                degree = Integer.parseInt(line);
                coefficient = fromStrArraytoDblArray(jin.readLine().split(" "));
                temp = fromStrArraytoDblArray(jin.readLine().split(" "));
                xLow = temp[0];
                xHigh = temp[1];
                inc = (int) temp[2];

                volume = calcVolume(coefficient, degree, xLow, xHigh);
                count++;
                jout.printf("Caso %d: %.2f\n", count, volume);
                if (volume < inc) {
                    jout.println("volumen insuficiente");
                } else {
                    // buscamos las marcas usando busqueda binaria
                    prev = .0;
                    mark = xHigh / 2.;
                    prevHigh = xHigh;
                    prevLow = .0;
                    sep = "";
                    cMarks = 0;
                    do {
                        tempVol = calcVolume(coefficient, degree, prev, mark);
                        if (((int)(tempVol * 100.)) == inc * 100) {
                            jout.printf("%s%.2f", sep, mark);
                            sep = " ";
                            prev = mark;
                            prevLow = mark;
                            prevHigh = xHigh;
                            mark = (xHigh + prev) / 2.;
                            cMarks++;
                        } else if (((int)(tempVol * 100.)) < inc * 100) {
                            prevLow = mark;
                            mark = (prevHigh + mark) / 2.;
                        } else {
                            prevHigh = mark;
                            mark = (mark + prevLow) / 2.;
                        }
                    } while (volume - (cMarks * inc) > inc && cMarks < 8);
                    jout.println();
                    // IGNORAR: "Workaround" para evitar el bug 
                    //          'unused assigned value' de netbeans 7.3+
                    Logger.getLogger(Intermedio02.class.getName())
                            .log(Level.INFO, "{0}{1}{2}{3}", new Object[]
                            {mark, prevHigh, prevLow, sep});
                    // IGNORAR!
                }
            }
        } while (line != null && !line.isEmpty());
    }

    private double calcVolume(double[] coef, int deg, double a, double b) {
        // Calculando el volumen de un sólido por rotación
        int newDegree = deg * 2;
        double volume;
        
        // calculamos los coeficiontes del polinomio de grado n * 2
        double[] aftCoef = new double[newDegree + 1];
        for (int i = 0; i <= deg; i++) {
            for (int j = 0; j <= deg; j++) {
                aftCoef[i + j] += coef[i] * coef[j];
            }
        }
        // calculamos el volumen en función al polinomio resultante
        volume = .0;
        for (int i = 0; i <= newDegree; i++) {
            volume += aftCoef[i]
                    * (Math.pow(b, i + 1) - Math.pow(a, i + 1))
                    / (i + 1);
        }
        // PI es constante, se excluye de la sumatoria y se multiplica al final
        return volume * Math.PI;
    }

    private double[] fromStrArraytoDblArray(String[] data) {
        double[] vector = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            vector[i] = Double.parseDouble(data[i]);
        }
        return vector;
    }
}

/*
Explicación:

Volumen de un sólido por rotación:

  Integral de p hasta q de PI * (f(x))^2 dx
  p y q son xlow y xhigh respectivaminte en el problema.

Solución de una integral donde f(x) es un polinomio de grado n

  Sumatoria de p hasta q (a_i ((q^i+1) - (p^i+1))/(i+1) 
  donce a_i son los coeficentes

  dado que el problema nos dice que f(x) es un polinomio de grado n
  y la definición del volumen de un sólido por rotación eleva dicho f(x) al 
  cuadrado, de operar dicha potencia obtenemos un polinomio de grado n*2.

Finalmente para buscar encontrar las marcas, debemos buscar los límites para
las cuales el volumen es igual a "inc", esto lo podemos hacer usando búsqueda
binaria.

 */
