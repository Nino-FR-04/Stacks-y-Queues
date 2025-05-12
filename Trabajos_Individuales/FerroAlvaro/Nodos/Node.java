package actividad2;
/**
 * Clase Nodo generica
 * @param <T>
 */ 
public class Node<T> {
		T dato;
		Node<T> next; 
		/**
		 * Constructor del dato  
		 * @param dato el dato se almacenara en este nodo
		 */
		public Node(T dato) {
			this.dato=dato; // se guarda el dato proporcionado
			this.next=null;  // se inicializa el next con null porque no hay nodo
		}
		public void setNext(Node<T> next) {
		    this.next = next;
		}
		public T getData() {
			return dato;
		}
		public Node<T> getNext() {
			// TODO Auto-generated method stub
			return next;
		}

	}

