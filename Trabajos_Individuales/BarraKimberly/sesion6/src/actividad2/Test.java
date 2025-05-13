package actividad2;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Cola de enteros
        Queue<Integer> colaEnteros = new QueueLink<>();

        // Cola de cadenas
        Queue<String> colaCadenas = new QueueLink<>();

        try {
            // Agregar elementos a cola de enteros
            colaEnteros.enqueue(5);
            colaEnteros.enqueue(10);
            colaEnteros.enqueue(15);
            System.out.println("Cola de enteros: " + colaEnteros);

            System.out.println("Primero (enteros): " + colaEnteros.front());
            System.out.println("Último (enteros): " + colaEnteros.back());
            colaEnteros.dequeue();
            System.out.println("Después de dequeue (enteros): " + colaEnteros);

            // Agregar elementos a cola de cadenas
            colaCadenas.enqueue("Hola");
            colaCadenas.enqueue("Mundo");
            System.out.println("\nCola de cadenas: " + colaCadenas);

            colaCadenas.dequeue();
            colaCadenas.enqueue("Java");
            System.out.println("Cola actual (cadenas): " + colaCadenas);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
