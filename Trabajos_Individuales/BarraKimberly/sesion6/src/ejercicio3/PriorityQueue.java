package ejercicio3;

import actividad1.ExceptionIsEmpty;

public interface PriorityQueue<E> {
    void enqueue(E x, int priority);
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    E back() throws ExceptionIsEmpty;
    boolean isEmpty();
}