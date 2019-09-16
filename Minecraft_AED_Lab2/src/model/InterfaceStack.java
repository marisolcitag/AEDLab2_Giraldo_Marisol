package model;

public interface InterfaceStack<E> {
	
	E top();
	
	boolean isEmpty();

	void push(E item);
	
	E pop();
}
