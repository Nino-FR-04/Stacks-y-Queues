package Trabajos_Individuales.FloresNino;

import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;
import Trabajos_Individuales.FloresNino.Stacks.StackLink;

//-------------Ejercicio 4
public class Ejercicios {

    /**
     * Método para verificar si los símbolos de una cadena están balanceados.
     * 
     * Utiliza una pila para asegurarse de que cada símbolo de apertura tenga su correspondiente
     * símbolo de cierre y estén en el orden correcto.
     * 
     * @param s Cadena de texto con símbolos a verificar.
     * @return {@code true} si los símbolos están balanceados, {@code false} en caso contrario.
     */
    public static boolean symbolBalancing(String s) {
        StackLink<Character> stack = new StackLink<>();

        for(int i=0 ; i<s.length() ; i++) {
            char symb = s.charAt(i);

            if(symb == '(' || symb == '[' || symb == '{') {
                stack.push(symb);
            } else if (symb == ')' || symb == ']' || symb == '}') {
                if(stack.isEmpty()) return false;

                try {
                    char tope = stack.pop();
                    if(!comparacion(tope, symb)) return false;
                
                } catch (ExceptionIsEmpty e) {
                    return false;
                }   
            }

        }

        return stack.isEmpty();

    }

    /**
     * Método privado para comparar un símbolo de apertura con su correspondiente símbolo de cierre.
     * 
     * @param apertura Símbolo de apertura.
     * @param cierre Símbolo de cierre.
     * @return {@code true} si la comparación es válida, {@code false} en caso contrario.
     */

    private static boolean comparacion(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') || 
                (apertura == '{' && cierre == '}') ||
                (apertura == '[' && cierre == ']');
    }

}
