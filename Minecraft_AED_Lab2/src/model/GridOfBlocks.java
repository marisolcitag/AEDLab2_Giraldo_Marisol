package model;


public class GridOfBlocks {
	//ATRIBUTOS
	public final static int MAX_AMMOUNT_OF_BLOCKS = 64;
	private int blocks;
	private String typeOfBlocks;
	
	//CONSTRUCTOR
	/**
	 * Nombre del Metodo: SetOfBlocks(String type, int blocks) 
	 * Descripción: Crear un nuevo SetofBlocks de un tipo especifico y una cantidad determinada
	 * The constructor allows to create a new SetOfBlocks with the specified
	 * @param type:tipo de bloques, blocks: cantidad de bloques
	 * */
	public GridOfBlocks(String type, int blocks) {
		if(blocks > MAX_AMMOUNT_OF_BLOCKS || blocks < 0) {
			throw new IllegalArgumentException("Ammount Invalid Requested");
		} else {
			this.blocks = blocks;
		}
		typeOfBlocks = type;
	}

	//METODOS
	/**
	 * Nombre del Metodo: getBlock()
	 * Descripción: Retorna la cantidad de bloques almacenados
	 * @return blocks: el total de bloques en el SetOfBlocks
	 * */
	public int getBlocks() {
		return blocks;
	}
	
	/**
	 * Nombre del Metodo:goToInventary()
	 * Descripción: Este metodo permite adicionar bloques al SetOfBlocks
	 * @param blocks El numero de bloques a adicionar
	 * @return blocks
	 * @throws IllegalArgumentException if blocks < 0
	 * */
	public int goToInventary(int blocks) {
		if(blocks < 0) {
			throw new IllegalArgumentException("The ammount of blocks to add must be positive");
		}
		
		int toAdd = -1;
		int freeSpace = MAX_AMMOUNT_OF_BLOCKS-this.blocks;
		if(freeSpace > 0) {
			toAdd = Math.min(blocks, freeSpace);
			blocks -= toAdd;
			this.blocks += toAdd;
		}
		return blocks;
	}
	
	/**
	 * Nombre del Metodo: takeIt(int blocks)
	 * Descripción: Tomar los bloques disponibles en el SetOfBlocks
	 * @param blocks El numero de bloques a tomar
	 * @throws IllegalArgumentException Si el numero de bloques excede el numero de bloques permitidos en el SetOfBlocks
	 * */
	public void takeIt(int blocks) {
		if(blocks > this.blocks) {
			throw new IllegalArgumentException("There are not enough blocks");
		}
		this.blocks -= blocks;
	}

	/**
	 * Nombre del Metodo: getTypeOfBlocks()
	 * Descripción: Retorna el tipo del bloque
	 * */
	public String getTypeOfBlocks() {
		return typeOfBlocks;
	}
	
	@Override
	public String toString() {
		return typeOfBlocks + "," + blocks;
	}
}
