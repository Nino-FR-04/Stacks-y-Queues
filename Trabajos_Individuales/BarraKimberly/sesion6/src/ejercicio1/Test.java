package ejercicio1;

import actividad1.ExceptionIsEmpty;
import actividad1.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> pilaEnteros = new StackLink<>();
        Stack<String> pilaCadenas = new StackLink<>();

        try {
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);
            System.out.println("Pila de enteros: " + pilaEnteros);
            System.out.println("Tope: " + pilaEnteros.top());
            pilaEnteros.pop();
            System.out.println("Después del pop: " + pilaEnteros);

            pilaCadenas.push("uno");
            pilaCadenas.push("dos");
            pilaCadenas.push("tres");
            System.out.println("Pila de cadenas: " + pilaCadenas);
            System.out.println("Tope: " + pilaCadenas.top());
            pilaCadenas.pop();
            System.out.println("Después del pop: " + pilaCadenas);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}