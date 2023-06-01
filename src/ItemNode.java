/*
 * Acts as a carrier for the items.
 * Used by the ItemsList to manipulate the items.
 */
public class ItemNode {
	private ItemNode next;
	private ItemNode previous;
	private Item data;

	//Constructor
	public ItemNode(Item data) {
		this.data = data;
		next = null;
		previous = null;
	}
	//Setters and getters
	public ItemNode getNext() {
		return next;
	}

	public ItemNode getPrevious() {
		return previous;
	}

	public Item getData() {
		return data;
	}

	public void setNext(ItemNode next) {
		this.next = next;
	}

	public void setPrevious(ItemNode previous) {
		this.previous = previous;
	}

	public void setData(Item data) {
		this.data = data;
	}

}
