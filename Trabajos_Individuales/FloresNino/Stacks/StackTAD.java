package Trabajos_Individuales.FloresNino.Stacks;
import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;

/**
 * Interfaz que define las operaciones básicas de una pila genérica.
 * 
 * @param E el tipo de elementos que almacena la pila.
 */

public interface StackTAD <E> {
    /**
     * Inserta un elemento en la cima de la pila.
     * @param obj el elemento a insertar.
     */
    public void push(E obj);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return el elemento removido de la cima.
     * @throws ExceptionIsEmpty si la pila está vacía.
     */
    public E pop() throws ExceptionIsEmpty;

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return el elemento en la cima.
     * @throws ExceptionIsEmpty si la pila está vacía.
     */
    public E top() throws ExceptionIsEmpty;

    /**
     * Elimina todos los elementos de la pila.
     * @throws ExceptionIsEmpty si la pila ya está vacía.
     */
    public void destroyStack() throws ExceptionIsEmpty;

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty();
}

/**
 * El metodo isFull() solo es aplicable en un Stack basado en un arreglo
 * estatico.
 */