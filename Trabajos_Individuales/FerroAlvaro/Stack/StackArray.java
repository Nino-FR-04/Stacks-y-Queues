package actividad1;
/**
 * se crear una pila generica utilizando un array
 * @param <E>
 */
public class StackArray<E> implements Stack<E>{ 
	private E[] stack;
	private int tope;
	/**
	 * se le asigna al stack la maxima capacidad
	 * @param maxC maximo cantida de elementso que puede tener
	 */
	public StackArray(int maxC) {
		this.stack=(E[]) new Object[maxC];
		this.tope=-1;
	}
	/**
	 * se crear un metodo push para ingresar valores 
	 */
	public void push(E x) {
		if(isFull()) {
			throw new RuntimeException("la lista esta llena");
		}
			this.stack[++this.tope]=x;
		
	}
	/** 
	 * se crear un metodo para eliminar el tope
	 * @throws verifica si esta vacia
	 * @return el elemento encima del stack
	 */
	public E pop() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new RuntimeException("la lista esta vacia");
		}else {
			E x=this.stack[this.tope];
			this.stack[this.tope--]=null;
			return x;
		}
	}
	/**
	 * metodo para mostar el tope del stack
	 * @throws verifica si la lista esta vacia
	 * @return return el tope del stacka 
	 */
	public E top() throws ExceptionIsEmpty{
		if(isEmpty()) {
			throw new RuntimeException("la lista esta vacia");
		}
		return this.stack[this.tope];
	}
	/**
	 * verifica si esta vacia 
	 * @return true si la lista esta vacia
	 */
	public boolean isEmpty() {
		return this.tope==-1;
	}
	/**
	 * metodo para ver si el stack esta lleno
	 * @return true si la lista esta llena
	 */
	public boolean isFull() {
		return this.tope==stack.length-1;
	}
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for (int i = 0; i <= tope; i++) {
	        sb.append(stack[i]);
	        if (i < tope) sb.append(", ");
	    }
	    sb.append("]");
	    return sb.toString();
	}

}
