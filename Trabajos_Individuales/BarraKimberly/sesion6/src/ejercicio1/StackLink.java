package ejercicio1;

import actividad1.ExceptionIsEmpty;
import actividad1.Stack;
import actividad2.Node;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(this.top);
        this.top = newNode;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("Pila vacía");
        }
        E data = this.top.getData();
        this.top = this.top.getNext();
        return data;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("Pila vacía");
        }
        return this.top.getData();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "Pila vacía";

        StringBuilder sb = new StringBuilder();
        Node<E> current = this.top;
        while (current != null) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}