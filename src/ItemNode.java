
public class ItemNode {
	private ItemNode next;
	private ItemNode previous;
	private Item data;
	
	public ItemNode(Item data) {
		this.data = data;
		next = null;
		previous = null;
	}
	
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
