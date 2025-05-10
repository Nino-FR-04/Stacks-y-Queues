package Trabajos_Individuales.FloresNino.Stacks;
import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;
import Trabajos_Individuales.FloresNino.Nodes.Node;

public class StackLink <E> implements StackTAD <E> {

    //Atributos
    private Node<E> tope;

    //Constructor
    public StackLink() {
        this.tope = null;
    }

    //---------Implementacion de metodos de la interfaz



    @Override
    public void push(E obj) {
        
        Node<E> nodo = new Node<>(obj);
        nodo.setNext(this.tope);
        this.tope = nodo;
        
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        
        if(this.isEmpty())
            throw new ExceptionIsEmpty("La pila esta vacia");
        
        E data = this.tope.getData();
        this.tope = this.tope.getNext();
        return data;

    }

    @Override
    public E top() throws ExceptionIsEmpty {
        
        if(this.isEmpty())
            throw new ExceptionIsEmpty("La pila esta vacia");
        
        return this.tope.getData();
    }

    @Override
    public void destroyStack() throws ExceptionIsEmpty {
        this.tope = null;
    }

    @Override
    public boolean isEmpty() {
        return this.tope == null;
    }
    
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");

        Node<E> actual = this.tope;

        while (actual.getNext() != null) {
            sb.append(actual.getData() + ", ");
            actual = actual.getNext();
        }

        sb.append(actual.getData() + "]");
        return sb.toString();
    }

}
