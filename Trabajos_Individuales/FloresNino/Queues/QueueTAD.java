package Trabajos_Individuales.FloresNino.Queues;
import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;

/**
 * Interfaz que define las operaciones básicas de una cola genérica.
 * 
 * @param E el tipo de elementos que almacena la pila.
 */

public interface QueueTAD <E> {
    public void enqueue(E obj);
    public E dequeue() throws ExceptionIsEmpty;
    public void destroyQueue() throws ExceptionIsEmpty;
    public boolean isEmpty();
    public E front() throws ExceptionIsEmpty;
    public E back() throws ExceptionIsEmpty;
}

/**
 * El metodo isFull() solo es aplicable en una Cola basada en un arreglo
 * estatico.
 */