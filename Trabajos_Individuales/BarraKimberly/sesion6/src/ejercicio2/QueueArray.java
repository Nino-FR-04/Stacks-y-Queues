package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad2.Queue;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int first;
    private int last;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    public void enqueue(E x) {
        if (size == capacity) {
            System.out.println("Cola llena. No se puede insertar.");
            return;
        }
        array[last] = x;
        last = (last + 1) % capacity;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        E data = array[first];
        array[first] = null;
        first = (first + 1) % capacity;
        size--;
        return data;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return array[first];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        int backIndex = (last - 1 + capacity) % capacity;
        return array[backIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Cola vacía";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int index = (first + i) % capacity;
            sb.append(array[index]);
            if (i < size - 1) sb.append(" -> ");
        }
        return sb.toString();
    }
}
