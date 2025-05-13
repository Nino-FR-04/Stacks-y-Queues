package ejercicio3;

import actividad1.ExceptionIsEmpty;

public class Test  {
    public static void main(String[] args) {
        try {
            PriorityQueue<String> colaPrioridad = new PriorityQueueLinked<>(3); // 3 niveles: 0 (alta), 1 (media), 2 (baja)

            colaPrioridad.enqueue("Urgente 1", 0);   // Prioridad más alta
            colaPrioridad.enqueue("Normal 1", 1);
            colaPrioridad.enqueue("Bajo 1", 2);
            colaPrioridad.enqueue("Urgente 2", 0);
            colaPrioridad.enqueue("Normal 2", 1);

            System.out.println("Estado de la cola de prioridad:\n" + colaPrioridad);

            System.out.println("Frente: " + colaPrioridad.front());
            System.out.println("Último: " + colaPrioridad.back());

            colaPrioridad.dequeue();
            System.out.println("Después de un dequeue:\n" + colaPrioridad);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}