package Trabajos_Individuales.FloresNino;

import Trabajos_Individuales.FloresNino.PriorityQueue.PriorityQueueLinkSort;
import Trabajos_Individuales.FloresNino.PriorityQueue.PriorityQueueLinked;
import Trabajos_Individuales.FloresNino.Queues.QueueArray;
import Trabajos_Individuales.FloresNino.Queues.QueueLink;
import Trabajos_Individuales.FloresNino.Stacks.StackArray;
import Trabajos_Individuales.FloresNino.Stacks.StackLink;

public class Main {
    public static void main(String[] args) {
        
        //------------STACKS
        System.out.println("-----------------> Stacks\n");
        System.out.println("STACK_ARRAY: ");
        
        StackArray<Integer> stacKArray = new StackArray<>(4);

        for (int i=0 ; i < 4 ; i++) {stacKArray.push(i);}

        System.out.println("Stack: " + stacKArray);
        System.out.println("Funcionamiento del pop: " + stacKArray.pop());
        System.out.println("Esta vacio?: " + stacKArray.isEmpty());
        System.out.println("Esta full?: " + stacKArray.isFull());
        System.out.println("Tope: " + stacKArray.top());

        System.out.println("Stack despues del pop: " + stacKArray);

        stacKArray.destroyStack();
        System.out.println("Stack despues de destruirlo: " + stacKArray);

        //----------------------------------------

        System.out.println("\nSTACK_LINK: ");
        
        StackLink<Integer> stacKLink = new StackLink<>();

        for (int i=0 ; i < 5 ; i++) {stacKLink.push(i);}

        System.out.println("Stack: " + stacKLink);
        stacKLink.pop(); //Borrar (4)
        System.out.println("Funcionamiento del pop: " + stacKLink.pop());
        System.out.println("Esta vacio?: " + stacKLink.isEmpty());
        System.out.println("Tope: " + stacKLink.top());

        System.out.println("Stack despues del pop: " + stacKLink);

        stacKLink.destroyStack();
        System.out.println("Stack despues de destruirlo: " + stacKLink);


        //------------Queues
        System.out.println("\n-----------------> Queues\n");

        System.out.println("QUEUE_ARRAY: ");
        QueueArray<Integer> queueArray = new QueueArray<>(3);

        // Encolar elementos
        for (int i = 0; i < 3; i++) {
            queueArray.enqueue(i);
        }

        System.out.println("Queue: " + queueArray);
        System.out.println("Desencolando: " + queueArray.dequeue());
        System.out.println("Queue después del dequeue: " + queueArray);
        System.out.println("Está vacío?: " + queueArray.isEmpty());
        System.out.println("Está llena?: " + queueArray.isFull());
        System.out.println("Elemento del front: " + queueArray.front());
        System.out.println("Elemento del back: " + queueArray.back());

        queueArray.destroyQueue();
        System.out.println("Queue después de destruirla: " + queueArray);

        //----------------------------------------

        System.out.println("\nQUEUE_LINK: ");
        
        QueueLink<Integer> queueLink = new QueueLink<>();

        // Encolar elementos
        for (int i = 0; i < 6; i++) {
            queueLink.enqueue(i);
        }

        System.out.println("Queue: " + queueLink);
        System.out.println("Desencolando: " + queueLink.dequeue());
        System.out.println("Queue después del dequeue: " + queueLink);
        System.out.println("Está vacío?: " + queueLink.isEmpty());
        System.out.println("Elemento del front: " + queueLink.front());
        System.out.println("Elemento del back: " + queueLink.back());
        
        queueLink.destroyQueue();
        System.out.println("Queue después de destruirla: " + queueLink);


        //------------ProrityQueues
        System.out.println("\n-----------------> PriorityQueues\n");
        System.out.println("PRIORITY_QUEUE_LINK_SORTED: ");

        PriorityQueueLinkSort<String, Integer> pq = new PriorityQueueLinkSort<>();

        // Encolar elementos con diferentes prioridades
        System.out.println("Encolando elementos: ");
        pq.enqueue("Elemento 1", 3);  // Prioridad 3
        pq.enqueue("Elemento 2", 1);  // Prioridad 1
        pq.enqueue("Elemento 3", 2);  // Prioridad 2
        pq.enqueue("Elemento 4", 1);  // Prioridad 1
        pq.enqueue("Elemento 5", 5);  // Prioridad 5

        System.out.println("Cola de Prioridad: " + pq);

        System.out.println("Desencolando en la cola de prioridad: " + pq.dequeue());
        System.out.println("Desencolando en la cola de prioridad: " + pq.dequeue());
        System.out.println("Queue de prioridad después del dequeue: " + pq);
        System.out.println("Esta vacio?: " + pq.isEmpty());
        System.out.println("Elemento del front (Menor prioridad - Valor): " + pq.front());
        System.out.println("Elemento del back (Mayor prioridad - Valor): " + pq.back());

        queueLink.destroyQueue();
        System.out.println("Queue de prioridad después de destruirla: " + pq);

        //---------------------------------------------------

        System.out.println("\nPRIORITY_QUEUE_LINKED: ");

        // Crear la cola de prioridad con un máximo de 5 niveles de prioridad
        PriorityQueueLinked<String, Integer> pql = new PriorityQueueLinked<>(6);

        // Encolar elementos con diferentes prioridades
        System.out.println("Encolando elementos: ");
        pql.enqueue("Elemento 1", 1);  // Prioridad 3
        pql.enqueue("Elemento 2", 5);  // Prioridad 1
        pql.enqueue("Elemento 3", 2);  // Prioridad 2
        pql.enqueue("Elemento 4", 5);  // Prioridad 1 (igual a Elemento 2)
        pql.enqueue("Elemento 5", 4);  // Prioridad 4

        // Mostrar el contenido de la cola
        System.out.println("Cola de Prioridad: " + pql);

        System.out.println("Desencolando en la cola de prioridad: " + pql.dequeue()); // Elemento 2
        System.out.println("Desencolando en la cola de prioridad: " + pql.dequeue()); // Elemento 4

        // Mostrar el estado de la cola después de desencolar
        System.out.println("Queue de prioridad después del dequeue: " + pql);
        System.out.println("¿Está vacía?: " + pql.isEmpty());
        
        pql.destroyQueue();
        System.out.println("Queue de prioridad después de destruirla: " + pql);


        //------------------------Ejercicio 4
        System.out.println("Ejercicio 4: Verificación de balanceo de símbolos");

        // Casos de prueba
        String test1 = "({[]})";    // Balancedo
        String test2 = "({[})";     // No balancedo
        String test3 = "{[()]}";    // Balancedo
        String test4 = "{[(])}";    // No balancedo
        String test5 = "((()))";    // Balancedo
        String test6 = "{[}";       // No balancedo

        // Verificando los resultados
        System.out.println("Test 1: " + test1 + " -> " + Ejercicios.symbolBalancing(test1));
        System.out.println("Test 2: " + test2 + " -> " + Ejercicios.symbolBalancing(test2));
        System.out.println("Test 3: " + test3 + " -> " + Ejercicios.symbolBalancing(test3));
        System.out.println("Test 4: " + test4 + " -> " + Ejercicios.symbolBalancing(test4));
        System.out.println("Test 5: " + test5 + " -> " + Ejercicios.symbolBalancing(test5));
        System.out.println("Test 6: " + test6 + " -> " + Ejercicios.symbolBalancing(test6));
    }
}
