package Trabajos_Individuales.FloresNino.Nodes;

/**
 * Clase que representa una entrada con un valor de datos y una prioridad asociada.
 * @param E el tipo del dato almacenado.
 * @param P el tipo de la prioridad asociada al dato.
 */

public class EntryNode <E,P> {
    private E data;
    private P priority;

    public EntryNode(E data, P priority) {
        this.data = data;
        this.priority = priority;
    }

    public E getData() {return this.data;}
    public P getPriority() {return this.priority;}
}
