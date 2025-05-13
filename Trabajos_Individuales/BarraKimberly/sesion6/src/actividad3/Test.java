package actividad3;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> cola = new PriorityQueueLinkSort<>();

            cola.enqueue("Tarea baja", 1);
            cola.enqueue("Tarea media", 5);
            cola.enqueue("Tarea urgente", 10);
            cola.enqueue("Tarea crítica", 15);

            System.out.println("Cola de prioridad:");
            System.out.println(cola);

            System.out.println("Elemento al frente: " + cola.front());
            System.out.println("Elemento al fondo: " + cola.back());

            System.out.println("Eliminando: " + cola.dequeue());
            System.out.println("Cola después del dequeue:");
            System.out.println(cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
