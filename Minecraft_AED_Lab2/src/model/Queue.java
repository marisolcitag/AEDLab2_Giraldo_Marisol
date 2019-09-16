package model;

public class Queue<E> implements InterfaceQueue<E> {
	
	//ATRIBUTOS
	private Node<E> front;
	private Node<E> back;
	private int size;

	//CONSTRUCTOR
	/**
	 *Nombre del Metodo: Queue()
	 *Descripci�n: Crear un Queue Empty
	 **/
	public Queue() {
		size = 0;
	}

	//METODOS
	/**
	 * Nombre de Metodo: front()
	 * Descripci�n: Retorna el elemento en el front de la queue sin modificarlo
	 * @return elemento front.
	 * */
	@Override
	public E front() {
		if(front != null) {
			return front.getElement();
		}
		return null;
	}

	/**
	 * Nombre de Metodo:isEmpty
	 * Descripci�n: Verifica si la queue est� empty
	 * @return <b>true</b> si la queue est� empty y <b>false</b> sino lo est�.
	 * */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Nombre de Metodo: enqueue(E element)
	 * Adds item to the queue
	 * @param item The item to insert<br>item != <b>null</b>
	 * */
	@Override
	public void enqueue(E element) {
		if(element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
		Node<E> newNode = new Node<>(element);
		if(isEmpty()) {
			front = newNode;
			back = front;
		} else {
			back.setNextNode(newNode);
			back = newNode;
		}
		size++;
	}

	/**
	 * Nombre de Metodo: dequeue()
	 * Descripcion: Quita y retorna el elemento front de laqueue
	 * @throws Exception si la queue est� empty
	 * */
	@Override
	public E dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty");
		}
		E e = front.getElement();
		front = front.getNextNode();
		if(front == null) {
			back = front;
		}
		size--;
		return e;
	}

	/**
	 * Nombre del Metodo: getSize()
	 * Descripci�n: Retorna el tama�o de la pila
	 * @return el tama�o  de la stack.
	 * */
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		Node<E> node = front;
		String ts = "";
		while(node != null) {
			ts += node+"\n";
			node = node.getNextNode();
		}
		return ts;
	}
}
