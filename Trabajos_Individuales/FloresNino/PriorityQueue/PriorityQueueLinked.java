package Trabajos_Individuales.FloresNino.PriorityQueue;

import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;
import Trabajos_Individuales.FloresNino.Queues.QueueLink;

/**
 * Implementación de una cola de prioridad utilizando un arreglo de colas enlazadas.
 * 
 * @param E Tipo de los elementos almacenados en la cola.
 * @param P Tipo del valor de prioridad (debe extender de Number).
 */
public class PriorityQueueLinked <E,P extends Number> 
    implements PriorityQueueTAD <E,P> {

    private QueueLink<E>[] queues;

    public PriorityQueueLinked(int maxPriority) {
        this.queues = (QueueLink<E>[]) new QueueLink<?>[maxPriority];
        for(int i=0 ; i<maxPriority ; i++) {
            this.queues[i] = new QueueLink<>();
        }
    }

    /**
     * Inserta un elemento en la cola según su prioridad.
     * 
     * @param obj Elemento a insertar.
     * @param pri Prioridad del elemento.
     * @throws IllegalArgumentException Si la prioridad está fuera de rango.
     */
    @Override
    public void enqueue(E obj, P pri) {
        int index = pri.intValue();
        
        if(index < 0 || index >= this.queues.length){
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }

        this.queues[index].enqueue(obj);
    }

    /**
     * Elimina y devuelve el elemento con mayor prioridad.
     * 
     * @return Elemento con mayor prioridad.
     * @throws ExceptionIsEmpty Si la cola está vacía.
     */
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < queues.length; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    /**
     * Elimina todos los elementos de todas las colas de prioridad.
     */
    @Override
    public void destroyQueue() {
        for (int i = 0; i < queues.length; i++) {
            queues[i].destroyQueue();
        }
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     * 
     * @return {@code true} si no hay elementos; {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        for (int i = 0; i < queues.length; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Devuelve el primer elemento (mayor prioridad) sin eliminarlo.
     * 
     * @return Elemento con mayor prioridad.
     * @throws ExceptionIsEmpty Si la cola está vacía.
     */
    @Override
    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < queues.length; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }

    /**
     * Devuelve el último elemento (menor prioridad) sin eliminarlo.
     * 
     * @return Elemento con menor prioridad.
     * @throws ExceptionIsEmpty Si la cola está vacía.
     */
    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = queues.length - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía");
    }    

    /**
     * Devuelve una representación en texto de la estructura completa.
     * 
     * @return Cadena con los elementos organizados por prioridad.
     */
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Contenido de PriorityQueueLinked:\n");
        
        for (int i = 0; i < queues.length; i++) {
            sb.append("Prioridad ").append(i).append(": ");
            sb.append(queues[i].toString()).append("\n");
        }

        return sb.toString();
    }
}
