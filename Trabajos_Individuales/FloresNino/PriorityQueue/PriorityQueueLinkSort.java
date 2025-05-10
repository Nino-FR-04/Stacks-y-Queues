package Trabajos_Individuales.FloresNino.PriorityQueue;

import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;
import Trabajos_Individuales.FloresNino.Nodes.EntryNode;
import Trabajos_Individuales.FloresNino.Nodes.Node;

/**
 * Implementación de una cola de prioridad usando una lista enlazada ordenada.
 * Los elementos se insertan de acuerdo con su prioridad, manteniendo el orden FIFO para elementos con igual prioridad.
 *
 * @param E Tipo de dato almacenado.
 * @param P Tipo de prioridad, que debe ser comparable.
 */

public class PriorityQueueLinkSort <E,P extends Comparable<P>> 
    implements PriorityQueueTAD <E,P> {

    //Atributos
    private Node<EntryNode<E,P>> first;
    private Node<EntryNode<E,P>> last;

    //Constructor
    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    //------------Implementación de los metodos de la interfaz
    /**
     * Inserta un elemento en la cola de prioridad según su prioridad.
     * 
     * @param obj Elemento a insertar.
     * @param pri Prioridad asociada al elemento.
     */
    @Override
    public void enqueue(E obj, P pri) {
        
        Node<EntryNode<E,P>> nodeAux = new Node<>(new EntryNode<>(obj, pri));

        //Caso 1: Cola Vacia
        if(this.isEmpty()) {
            this.first = nodeAux;
            this.last = nodeAux;
            return;
        }

        /*
        Caso 2: Insercion al principio teniendo en cuenta que el primer elemento tiene mayor prioridad
        que el que se quiere insertar
        */
        if(pri.compareTo(this.first.getData().getPriority()) < 0) {
            nodeAux.setNext(this.first);
            this.first = nodeAux;
            return;
        }

        /*
        Caso 3: Insercion al final teniendo en cuenta que el ultimo elemento tiene menor prioridad
        que el que se quiere insertar
        */
        if(pri.compareTo(this.last.getData().getPriority()) >= 0) {
            this.last.setNext(nodeAux);
            this.last = nodeAux;
            return;
        }

        /*
        Caso 4: Inserción en una posición intermedia, manteniendo el orden por prioridad.
        Si hay varios elementos con la misma prioridad, se insertará después de ellos (respeta FIFO entre iguales).
        */
        Node<EntryNode<E,P>> actual = this.first;

        while(actual.getNext() != null && 
                actual.getNext().getData().getPriority().compareTo(pri) <= 0) {

            actual = actual.getNext();
        }

        nodeAux.setNext(actual.getNext());
        actual.setNext(nodeAux);

    }

    /**
     * Elimina y devuelve el elemento con mayor prioridad (al frente de la cola).
     * 
     * @return Elemento al frente de la cola.
     * @throws ExceptionIsEmpty Si la cola está vacía.
     */
    @Override
    public E dequeue() throws ExceptionIsEmpty {

        if(this.isEmpty())
            throw new ExceptionIsEmpty("La cola de prioridad esta vacia");
        
        E data = this.first.getData().getData();
        this.first = this.first.getNext();

        if(this.first == null) {
            this.last = null;
        }

        return data;
    }

    /**
     * Elimina todos los elementos de la cola.
     */
    @Override
    public void destroyQueue() {
        this.first = null;
        this.last = null;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola no contiene elementos, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Devuelve el elemento al frente de la cola sin eliminarlo.
     * 
     * @return Elemento al frente.
     * @throws ExceptionIsEmpty Si la cola está vacía.
     */
    @Override
    public E front() throws ExceptionIsEmpty {
        if(this.isEmpty())
            throw new ExceptionIsEmpty("La cola de prioridad esta vacia");
        
        return this.first.getData().getData();
    }

    /**
     * Devuelve el último elemento en la cola sin eliminarlo.
     * 
     * @return Último elemento en la cola.
     * @throws ExceptionIsEmpty Si la cola está vacía.
     */
    @Override
    public E back() throws ExceptionIsEmpty {
        if(this.isEmpty())
            throw new ExceptionIsEmpty("La cola de prioridad esta vacia");
        
        return this.last.getData().getData();
    }
    

    //Representacion de la cola en forma de cadena de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<EntryNode<E,P>> actual = this.first;

        while (actual != null) {
            EntryNode<E,P> entry = actual.getData();
            sb.append("(").append(entry.getData()).append(", ").append(entry.getPriority()).append(")");
            if (actual.getNext() != null) {
                sb.append(", ");
            }
            actual = actual.getNext();
        }

        sb.append("]");
        return sb.toString();
    }
}
