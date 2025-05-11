package Trabajos_Individuales.FloresNino.PriorityQueue;
import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;

/**
 * Interfaz que define las operaciones básicas de una cola genérica.
 * 
 * @param E el tipo de elementos que almacena la pila.
 * @param P el tipo de prioridad
 */

public interface PriorityQueueTAD <E,P> {
    public void enqueue(E obj, P pri);
    public E dequeue() throws ExceptionIsEmpty;
    public void destroyQueue();
    public boolean isEmpty();
    public E front() throws ExceptionIsEmpty;
    public E back() throws ExceptionIsEmpty;
}

/**
 * El metodo isFull() solo es aplicable en una Cola basada en un arreglo
 * estatico.
 */