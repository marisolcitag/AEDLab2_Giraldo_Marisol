package model;

public interface InterfaceQueue<E> {
	
	E front();
	
	boolean isEmpty();
	
	void enqueue(E item);
	
	E dequeue() throws Exception;
}
