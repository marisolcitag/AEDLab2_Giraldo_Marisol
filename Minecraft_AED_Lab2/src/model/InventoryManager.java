package model;

import java.util.ArrayList;

public class InventoryManager {
	private OpenAddressingHashTable<String, Stack<GridOfBlocks>> keyRegistry;
	private OpenAddressingHashTable<String, GridOfBlocks> inventory;
	private Queue<Stack<GridOfBlocks>> quickAccessBars;
	private ArrayList<String> randomlyGeneratedKeys;
	
	public final static GenerateKey<String> gKey = new GenerateKey<String>() {
		@Override
		public int keyToInteger(String key) {
			int length = key.length();
			int intKey = 0;
			for (int i = 0; i < length; i++) {
				char chari = key.charAt(i);
				if(chari > 122 || chari < 46) {
					throw new IllegalArgumentException("The key contains an invalid character: " + chari);
				} else {
					intKey += chari*Math.pow(128, length - i - 1);
				}
			}
			return intKey;
		}
	};

	public InventoryManager() {
		keyRegistry = new OpenAddressingHashTable<>(27, gKey);
		inventory = new OpenAddressingHashTable<>(27, gKey);
		quickAccessBars = new Queue<>();
		randomlyGeneratedKeys = new ArrayList<>();
	}

	public void goToInventary(String typeOfBlock, int amount) throws Exception {
		Stack<GridOfBlocks>  registryStack = keyRegistry.search(typeOfBlock);
		if(registryStack == null && inventory.getStoredItems() < inventory.getItems().length) {
			registryStack = new Stack<GridOfBlocks>();
			keyRegistry.add(typeOfBlock, registryStack);
			quickAccessBars.enqueue(registryStack);
		}
	}

	public void takeIt(int amount) throws Exception {
	}

	public OpenAddressingHashTable<String, Stack<GridOfBlocks>> getKeyRegistry() {
		return keyRegistry;
	}

	public void setKeyRegistry(OpenAddressingHashTable<String, Stack<GridOfBlocks>> keyRegistry) {
		this.keyRegistry = keyRegistry;
	}

	public OpenAddressingHashTable<String, GridOfBlocks> getInventory() {
		return inventory;
	}

	public void setInventory(OpenAddressingHashTable<String, GridOfBlocks> inventory) {
		this.inventory = inventory;
	}

	public Queue<Stack<GridOfBlocks>> getQuickAccessBars() {
		return quickAccessBars;
	}

	public void setQuickAccessBars(Queue<Stack<GridOfBlocks>> quickAccessBars) {
		this.quickAccessBars = quickAccessBars;
	}


	public ArrayList<String> getRandomlyGeneratedKeys() {
		return randomlyGeneratedKeys;
	}
}
