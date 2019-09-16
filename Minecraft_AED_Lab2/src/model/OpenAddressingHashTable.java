package model;

public class OpenAddressingHashTable<K, V> implements InterfaceHashTable<K, V> {
	
	//ATRIBUTOS
	public final static double A = (Math.sqrt(7)-1.0)/2.0;
	private HashTableNode<K, V>[] items; //The array or table
	private boolean[] DELETED; 
	private int storedItems;
	private GenerateKey<K> gKey;

	//CONTRUCTOR
	public OpenAddressingHashTable(int size, GenerateKey<K> it) {
		items = (HashTableNode<K, V>[])new HashTableNode[size];
		DELETED = new boolean[size];
		storedItems = 0;
		gKey = it;
	}

	//METODOS
	@Override
	public V search(K key) {
		int h = hashFunction(true, key);
		if(h != -1 && !DELETED[h]) {
			return items[h].getValue();
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int h = hashFunction(true, key);
		if(h != -1 && !DELETED[h]) {
			DELETED[h] = true;
			storedItems--;
			return items[h].getValue();
		} 
		return null;
	}

	@Override
	public void add(K key, V value) {
		if(storedItems == items.length) {
			throw new IllegalStateException("The hash table is already full");
		}
		int h = hashFunction(false, key);
		if(h != -1) {
			items[h] = new HashTableNode<>(key, value);
			storedItems++;
			DELETED[h] = false;
		}
	}

	public HashTableNode<K, V>[] getItems() {
		return items;
	}

	public void setItems(HashTableNode<K, V>[] items) {
		this.items = items;
	}

	public int getStoredItems() {
		return storedItems;
	}

	public boolean[] getDELETED() {
		return DELETED;
	}

	public int hashFunction(boolean search, K key) {
		int hashCode=-1;
		
		return hashCode;
	}
}
