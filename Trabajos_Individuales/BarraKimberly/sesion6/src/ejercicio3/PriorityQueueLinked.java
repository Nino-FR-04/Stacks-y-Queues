package ejercicio3;

import actividad1.ExceptionIsEmpty;
import actividad2.QueueLink;

public class PriorityQueueLinked<E> implements PriorityQueue<E> {
    private QueueLink<E>[] queues;
    private int numPriorities;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int numPriorities) {
        this.numPriorities = numPriorities;
        this.queues = new QueueLink[numPriorities];
        for (int i = 0; i < numPriorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    
    public void enqueue(E x, int priority) {
        if (priority < 0 || priority >= numPriorities) {
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }
        queues[priority].enqueue(x);
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    public E back() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    public boolean isEmpty() {
        for (QueueLink<E> q : queues) {
            if (!q.isEmpty()) return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numPriorities; i++) {
            sb.append("Prioridad ").append(i).append(": ").append(queues[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
