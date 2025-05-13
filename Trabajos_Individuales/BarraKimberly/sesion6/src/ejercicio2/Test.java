package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad2.Queue;

public class Test {
    public static void main(String[] args) {
        try {
            Queue<Integer> cola = new QueueArray<>(5);
            cola.enqueue(10);
            cola.enqueue(20);
            cola.enqueue(30);

            System.out.println("Contenido de la cola: " + cola);

            System.out.println("Front: " + cola.front());
            System.out.println("Back: " + cola.back());

            cola.dequeue();
            System.out.println("Después de eliminar uno: " + cola);

            cola.enqueue(40);
            cola.enqueue(50);
            cola.enqueue(60); 
            System.out.println("Después de agregar más: " + cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
