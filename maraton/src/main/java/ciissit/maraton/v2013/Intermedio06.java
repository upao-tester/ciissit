package ciissit.maraton.v2013;

import ciissit.maraton.Template;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Solución a All your base (mismo problema que básico 5)
 * 
 * @author Martín Canaval
 */
public class Intermedio06 extends Template { 

    public static void main(String[] args) {
        new Intermedio06().init(args);
    }

    @Override
    public void start(BufferedReader jin, PrintStream jout) throws IOException {
        // TODO: Validar entrada
        String message;
        String normalizedMsg;
        String normalSymbols = "0123456789abcdefghijklmnopqrstuvwxyz";
        String foundSymbols;
        int base;
        long minValuePossible;
                
        int t = Integer.parseInt(jin.readLine());
        for (int i = 0; i < t; i++) {
            message = jin.readLine();
            foundSymbols = "";
            // TODO: Usar StringBuilder
            // Identificando simbolos únicos en el mensaje.
            for (int j = 0; j < message.length(); j++) {
                if(foundSymbols.indexOf("" + message.charAt(j)) == -1) {
                    if(foundSymbols.length() == 1) {
                        // invertimos primer y segundo elemento (0 y 1)
                        foundSymbols = message.charAt(j) + foundSymbols;
                    } else {
                        foundSymbols += message.charAt(j);
                    }
                }
            }
            base = foundSymbols.length();
            normalizedMsg = "";
            for (int j = 0; j < message.length(); j++) {
                normalizedMsg += normalSymbols.charAt(
                        foundSymbols.indexOf(message.charAt(j)));
            }
            minValuePossible = Long.parseLong(normalizedMsg, base);
            jout.printf("Caso %d: %d\n", (i + 1), minValuePossible);
        }
    }
}

/*

Nota: Este es el mismo problema 05 de nivel básico.
 
Explicación: 

Tenemos secuencias de caracteres que representan un número, no sabemos la base
ni el orden de los dígitos. Pero nos piden hallar el valor mímimo que dicho
número podría representar.
 
Para que el número sea el más pequeño posible, debemos asumir que debe ser
el número más pequeño de la base más pequeña. 

Para determinar la base simplemente contamos el número total de dígitos 
diferentes.

Sabemos que no puede empezar en cero, por lo tanto, todos los números deben
empezar en 1, luego, los siguientes dígitos diferentes deben ir de menor a 
mayor peso, por ejemplo:
Mensaje Original  |  Mensaje Normalizado  |  Base
------------------------------------------------------
zig                  102                     3
ffss33ffg            110022113               4
cats                 1023                    4

Finalmente solo resta convertir de base "n" a base 10.
*/
