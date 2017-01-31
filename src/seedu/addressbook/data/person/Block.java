package seedu.addressbook.data.person;

public class Block {
	
	private final String block;
	
	public Block(String block) {
		this.block = block;
	}

	public String toString() {
		return block;
	}
	
	public String getBlock() {
		return this.block;
	}
}
