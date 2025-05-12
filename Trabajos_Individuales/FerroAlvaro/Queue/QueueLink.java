package actividad2;


public class QueueLink<E> implements Queue<E> {
	private Node<E> first; 
	private Node<E> last; 
	
	public QueueLink() {
		this.first=null;
		this.last=null;
	}

	public void enqueue(E x) {
		Node<E> aux=new Node<E>(x); 
		if(this.isEmpty()) {
			this.first=this.last=aux;
		}else {
			this.last.setNext(aux); 
			this.last=aux;
		}
		
	}

	public E dequeue() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Erro: cola vacia"); 
		}else{
			E data=this.first.getData(); 
			this.first=this.first.getNext(); 
			if(this.first==null) {
				this.last=null;
			}
			return data; 
		}
	}

	public E front() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Erro: cola vacia"); 
		}return this.first.getData();
	}

	public E back() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Erro: cola vacia"); 
		}return this.last.getData();
	}

	public boolean isEmpty() {
		return first==null;
	}
}
