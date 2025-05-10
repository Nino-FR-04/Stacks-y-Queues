package Trabajos_Individuales.FloresNino.PriorityQueue;

import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;
import Trabajos_Individuales.FloresNino.Nodes.EntryNode;
import Trabajos_Individuales.FloresNino.Nodes.Node;

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

    @Override
    public void destroyQueue() {
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if(this.isEmpty())
            throw new ExceptionIsEmpty("La cola de prioridad esta vacia");
        
        return this.first.getData().getData();
    }

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
