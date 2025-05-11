package Trabajos_Individuales.FloresNino.Queues;

import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;

/**
 * Implementación de una cola utilizando un arreglo con capacidad fija.
 * La cola sigue un comportamiento circular, utilizando aritmética modular
 * para gestionar las posiciones de los elementos.
 *
 * @param E Tipo de los elementos en la cola.
 */
public class QueueArray <E> implements QueueTAD <E> {
    
    //Atributos
    private int first;
    private int last;
    private E[] queue;

    //Constructor
    /**
     * Constructor de la cola. Inicializa el arreglo de la cola con el tamaño máximo 
     * indicado y establece los índices de `first` y `last` en -1, indicando que la cola está vacía.
     *
     * @param maxCapacity Tamaño máximo de la cola
     */
    @SuppressWarnings("unchecked")
    public QueueArray(int maxCapacity) {
        this.queue = (E[]) new Object[maxCapacity];
        this.first = -1;
        this.last = -1;
    }

    //Implementación de metodos de la interfaz
    /**
     * Inserta un elemento en la cola, si no está llena.
     * La inserción se realiza en la posición de `last`, y si la cola está vacía, 
     * se actualizan los índices `first` y `last` al primer elemento.
     *
     * @param obj El objeto que se insertará en la cola
     * @throws RuntimeException Si la cola está llena
     */
    @Override
    public void enqueue(E obj){
        if (this.isFull()) {
            throw new RuntimeException("La cola está llena");
        }

        if (this.isEmpty()) {
            this.first++;
            this.last++;
            this.queue[this.last] = obj;
        } else {
            this.last = (this.last + 1) % this.queue.length;
            this.queue[this.last] = obj;
        }
    }

    /**
     * Elimina el primer elemento de la cola y lo retorna.
     * Si la cola queda vacía después de la eliminación, 
     * los índices `first` y `last` se restablecen a -1.
     *
     * @return El elemento eliminado de la cola
     * @throws ExceptionIsEmpty Si la cola está vacía
     */
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }

        E elemento = this.queue[this.first];
        this.queue[this.first] = null;

        if (this.first == this.last) {
            this.first = -1;
            this.last = -1;
        } else {
            this.first = (this.first + 1) % this.queue.length;
        }

        return elemento;
    }

    /**
     * Elimina todos los elementos de la cola, dejando la cola vacía.
     */
    @Override
    public void destroyQueue() {
        this.queue = (E[]) new Object[this.queue.length];
        this.first = -1;
        this.last = -1;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false si no
     */
    @Override
    public boolean isEmpty() {
        return this.first == -1 && this.last == -1;
    }

    /**
     * Obtiene el primer elemento de la cola sin eliminarlo.
     *
     * @return El primer elemento de la cola
     * @throws ExceptionIsEmpty Si la cola está vacía
     */
    @Override
    public E front() throws ExceptionIsEmpty {
        if(this.isEmpty())
            throw new ExceptionIsEmpty("La cola esta vacia");
        
        return this.queue[this.first];
    }

    /**
     * Obtiene el último elemento de la cola sin eliminarlo.
     *
     * @return El último elemento de la cola
     * @throws ExceptionIsEmpty Si la cola está vacía
     */
    @Override
    public E back() throws ExceptionIsEmpty {
        if(this.isEmpty())
            throw new ExceptionIsEmpty("La cola esta vacia");
        
        return this.queue[this.last];
    }

    /**
     * Verifica si la cola está llena.
     * La cola está llena si el siguiente índice de `last` es igual a `first`.
     *
     * @return true si la cola está llena, false si no
     */
    public boolean isFull() {
        return ((this.last + 1) % this.queue.length) == this.first;
    }

    /**
     * Devuelve una representación en cadena de la cola.
     *
     * @return Cadena que representa el contenido de la cola
     */
    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        int i = first;
        while (true) {
            sb.append(this.queue[i]);
            if (i == this.last) break;
            sb.append(", ");
            i = (i + 1) % this.queue.length;
        }
        sb.append("]");
        return sb.toString();
    }

}
