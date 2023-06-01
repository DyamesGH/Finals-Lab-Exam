
public class OrderNode {
	private int itemID;
	private int quantity;
	private double price;
	private OrderNode next;
	private OrderNode previous;

	OrderNode() {
		
	}

	OrderNode(int itemID, int quantity, double price) {
		this.itemID = itemID;
		this.quantity = quantity;
		this.price = price;
		next = null;
		previous = null;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public OrderNode getNext() {
		return next;
	}

	public void setNext(OrderNode next) {
		this.next = next;
	}

	public OrderNode getPrevious() {
		return previous;
	}

	public void setPrevious(OrderNode previous) {
		this.previous = previous;
	}

}