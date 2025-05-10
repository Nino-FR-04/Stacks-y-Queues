package Trabajos_Individuales.FloresNino.Queues;

import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;
import Trabajos_Individuales.FloresNino.Nodes.Node;

/**
 * Implementación de una cola genérica utilizando una lista enlazada.
 * @param E el tipo de elementos
 */

public class QueueLink <E> implements QueueTAD <E> {

    //Atributos
    private Node<E> first;
    private Node<E> last;

    //Constructor
    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    //-----------Implementacion de los metodos de la Interfaz


    @Override
    public void enqueue(E obj) {

        Node<E> nodeAux = new Node<> (obj);

        if(this.isEmpty()) {
            this.first = nodeAux;
            this.last = nodeAux;
        }else {
            this.last.setNext(nodeAux);
            this.last = nodeAux;
        }

    }
    
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if(this.isEmpty())
            throw new ExceptionIsEmpty("Cola vacia");
        
        E data = this.first.getData();
        this.first = this.first.getNext();

        if(this.first == null) {
            this.last = null;
        }

        return data;
    }

    @Override
    public void destroyQueue() throws ExceptionIsEmpty {
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
            throw new ExceptionIsEmpty("Cola vacia");
        
        return this.first.getData();
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if(this.isEmpty())
            throw new ExceptionIsEmpty("Cola vacia");
        
        return this.last.getData();
    }
    
}
