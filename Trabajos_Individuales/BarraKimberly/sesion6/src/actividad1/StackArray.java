package actividad1;

public class StackArray<E> implements Stack<E> {
	private E[] array;
	private int tope;
	@SuppressWarnings("unchecked")
	public StackArray(int n) {
		this.array = (E[]) new Object[n];
		tope = -1;
	}
	public void push(E x) { 
		if(isFull()) {
			throw new RuntimeException("pila llena");
		}
		array[++tope] =x;
	}
	public E pop() throws ExceptionIsEmpty{
		if(isEmpty()) {
			throw new ExceptionIsEmpty("la pila esta vacia");
		}
		return array[tope--];
	}
	public E top() throws ExceptionIsEmpty{
		if(isEmpty()) {
			throw new ExceptionIsEmpty("la pila esta vacia");
		}
		return array[tope];
	}
	public boolean isEmpty() {
		return this.tope ==-1;
	}
	public boolean isFull() {
		return tope == array.length -1;
		
	}
	public String toString() {
		if (isEmpty()) {
	        return "la pila esta vacia";
	    }

	    StringBuilder sb = new StringBuilder();
	    for (int i = tope; i >= 0; i--) {
	        sb.append(array[i]);
	        if (i != 0) {
	            sb.append(" -> ");
	        }
	    }
	    return sb.toString();
		
	}

}
