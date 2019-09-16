package model;

public class Node<E> {
	
	//ATRIBUTOS
	private E element;
	private Node<E> nextNode;
	
	//CONTRUCTOR
	public Node(E element) {
		this.element = element;
	}
	
	//METODOS
	public E getElement() {
		return element;
	}
	
	public void setElement(E element) {
		this.element = element;
	}
	
	public Node<E> getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(Node<E> nextNode) {
		this.nextNode = nextNode;
	}
	
	@Override
	public String toString() {
		return element+"";
	}
}
