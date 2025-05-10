package Trabajos_Individuales.FloresNino.Stacks;
import Trabajos_Individuales.FloresNino.Excepciones.ExceptionIsEmpty;

/**
 * Implementación de una pila genérica utilizando un arreglo.
 * @param E el tipo de elementos
 */
public class StackArray <E> implements StackTAD <E> {

    //Atributos
    private E[] stack;
    private int tope;

    //Constructor
    /**
     * Construye una pila con la capacidad máxima especificada.
     * @param maxCapacity la cantidad máxima de elementos que la pila puede contener
     */
    @SuppressWarnings("unchecked")
    public StackArray(int maxCapacity) {
        this.stack = (E[]) new Object[maxCapacity];
        this.tope = -1;
    }

        /**
     * Inserta un elemento en la cima de la pila.
     * @param obj el elemento a insertar
     * @throws RuntimeException si la pila está llena
     */
    @Override
    public void push(E obj) {
        
        if(this.isFull()) 
            throw new RuntimeException("Error: Stack lleno");
        
        this.stack[++this.tope] = obj;

    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return el elemento en la cima de la pila
     * @throws ExceptionIsEmpty si la pila está vacía
     */
    @Override
    public E pop() throws ExceptionIsEmpty {
        if(this.isEmpty()) 
            throw new ExceptionIsEmpty("Stack vacio");

        E obj = this.stack[this.tope];
        this.stack[this.tope--] = null;

        return obj;

    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return el elemento en la cima de la pila
     * @throws ExceptionIsEmpty si la pila está vacía
     */
    @Override
    public E top() throws ExceptionIsEmpty {
        if(this.isEmpty()) 
            throw new ExceptionIsEmpty("Stack vacio");

        return this.stack[tope];
    }

    /**
     * Destruye la pila eliminando todos los elementos y reiniciando el índice de la cima.
     * @throws ExceptionIsEmpty si la pila está vacía
     */
    @SuppressWarnings("unchecked")
    @Override
    public void destroyStack() throws ExceptionIsEmpty {
        if(this.isEmpty()) 
            throw new ExceptionIsEmpty("Stack vacio");

        this.stack = (E[]) new Object[this.stack.length];
        this.tope = -1;
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return this.tope == -1;
    }
    
    /**
     * Verifica si la pila está llena.
     * @return true si la pila está llena, false en caso contrario
     */
    public boolean isFull() {
        return this.tope == this.stack.length - 1;
    }

    /**
     * Muestra la Pila en forma de cadena
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = this.tope; i >= 0; i--) {
            sb.append(this.stack[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
