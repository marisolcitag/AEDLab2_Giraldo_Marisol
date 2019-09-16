package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class GridOfBlocksTest {
	private GridOfBlocks gob;
	
	@Test
	public void createGridOfBlocksTest() {
		int blocks = -1;
		String typeOfBlock = "";
		try {
			blocks = 0;
			typeOfBlock = "Gold";
			gob = new GridOfBlocks(typeOfBlock, blocks);
			assertTrue(gob.getTypeOfBlocks().equals(typeOfBlock), "The type of block is not the requested");
			assertTrue(gob.getBlocks() == blocks, "The number of blocks is not the requested");
		} catch(IllegalArgumentException iae) {
			fail("The arguments were valid");
		}
		
		try {
			blocks = -10;
			typeOfBlock = "Gold";
			gob = new GridOfBlocks(typeOfBlock, blocks);
			fail("The arguments were not valid");
		} catch(IllegalArgumentException iae) {
			assertTrue(true);
		}
		
		try {
			blocks = 55;
			typeOfBlock = "Gold";
			gob = new GridOfBlocks(typeOfBlock, blocks);
			fail("The arguments were not valid");
		} catch(IllegalArgumentException iae) {
			assertTrue(true);
		}
	}
	
	@Test
	public void goToInventory() {
		gob = new GridOfBlocks("TNT", 0);
		int toAdd = 100;
		int freeSpace = GridOfBlocks.MAX_AMMOUNT_OF_BLOCKS-gob.getBlocks();
		int remainingToCollect = gob.goToInventary(toAdd);
		assertTrue(toAdd - freeSpace == remainingToCollect, "The remaining blocks must be the difference between the blocks to add and the free space");
	}
	
	@Test
	public void takeIt() {
		gob = new GridOfBlocks("Diamond", 0);
		int blocksToRemove = 5;
		try {
			gob.takeIt(blocksToRemove);
			fail("There are not enough blocks to remove "+blocksToRemove+ " blocks");
		} catch(IllegalArgumentException iae) {
			assertTrue(true);
		}
		
		gob = new GridOfBlocks("Diamond", 25);
		blocksToRemove = 35;
		try {
			gob.takeIt(blocksToRemove);
			fail("There are not enough blocks to remove "+blocksToRemove+ " blocks");
		} catch(IllegalArgumentException iae) {
			assertTrue(true);
		}
	}
}
