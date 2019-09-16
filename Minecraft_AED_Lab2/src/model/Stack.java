package model;

import java.util.EmptyStackException;

public class Stack<E> implements InterfaceStack<E> {
	
	//ATRIBUTOS
	private Node<E> top;
	private int size;

	//CONSTRUCTOR
	/**
	 *Nombre del Metodo: Stack()
	 *Descripción: Crear un Stack Empty
	 **/
	public Stack() {
		size = 0;
	}

	//METODOS
	/**Nombre del Metodo: top()
	 * Descripción: Retorna el elemento top del stack.
	 * @return El elemento top del stack. 
	 * */
	@Override
	public E top() {
		if(top != null) {
			return top.getElement();
		}
		return null;
	}

	/**
	 * Nombre del Metodo: isEmpty()
	 * Descripción: Verifica si el stack esta empty
	 * @return <b>true</b> si el stack esta empty and <b>false</b> sino lo está.
	 * */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Nombre del Metodo: push(E item)
	 * Descripción: Inserta un item en el stack
	 * @param element The elemento a insertar en el stack</b> 
	 * */
	@Override
	public void push(E element) {
		Node<E> newNode = new Node<>(element);
		newNode.setNextNode(top);
		top = newNode;
		size++;
	}

	/**
	 * Nombre del metodo:pop
	 * Descripción: Quita y retorna el elemento top de la pila
	 * @return element El elemento top de la pila
	 * @throws EmptyStackException Si la pila está empty
	 * */
	@Override
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		E element = top.getElement();
		top = top.getNextNode();
		size--;
		return element;
	}

	/**
	 * Nombre del Metodo: getSize()
	 * Descripción: Retorna el tamaño de la pila
	 * @return el tamaño  de la stack.
	 * */
	public int getSize() {
		return size;
	}
	
	/**
	 * Nombre del Metodo: toString()
	 * Descripción: Retorna 
	 * @return 
	 * */
	@Override
	public String toString() {
		String ts = "";
		Node<E> node = top;
		while(node != null) {
			ts += node+"\n";
			node = node.getNextNode();
		}
		return ts;
	}
}
