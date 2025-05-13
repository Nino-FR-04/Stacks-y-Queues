package actividad3;

import actividad1.ExceptionIsEmpty;
import actividad2.Node;

public class PriorityQueueLinkSort <E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    private static class EntryNode<E, N> {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }

        public String toString() {
            return data + " (prioridad: " + priority + ")";
        }
    }

    private Node<EntryNode<E, N>> first;
    private Node<EntryNode<E, N>> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, N pr) {
        EntryNode<E, N> newEntry = new EntryNode<>(x, pr);
        Node<EntryNode<E, N>> newNode = new Node<>(newEntry);

        if (isEmpty()) {
            first = last = newNode;
        } else if (pr.compareTo(first.getData().priority) > 0) {
            // Insert at the beginning
            newNode.setNext(first);
            first = newNode;
        } else {
            // Traverse to find position
            Node<EntryNode<E, N>> current = first;
            Node<EntryNode<E, N>> previous = null;

            while (current != null && pr.compareTo(current.getData().priority) <= 0) {
                previous = current;
                current = current.getNext();
            }

            newNode.setNext(current);
            if (previous != null) previous.setNext(newNode);
            if (current == null) last = newNode;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E aux = first.getData().data;
        first = first.getNext();
        if (first == null) last = null;
        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return first.getData().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return last.getData().data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Cola vacía";
        StringBuilder sb = new StringBuilder();
        Node<EntryNode<E, N>> current = first;
        while (current != null) {
            sb.append(current.getData().toString());
            if (current.getNext() != null) sb.append(" -> ");
            current = current.getNext();
        }
        return sb.toString();
    }
}
