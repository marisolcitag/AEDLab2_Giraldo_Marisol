package model;

public class HashTableNode<K, V> {
	
	//ATRIBUTOS
	private K key;
	private V value;
	
	//CONSTRUCTOR
	public HashTableNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	//METODOS
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "("+key+","+value+")";
	}
}
