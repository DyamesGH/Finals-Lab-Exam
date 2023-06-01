
public class TransactionNode {
	private int transactionID;
	private int totalPrice;
	private OrderList orderList = new OrderList();
	private TransactionNode next;
	private TransactionNode previous;

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderList getOrderList() {
		return orderList;
	}

	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}

	public TransactionNode getNext() {
		return next;
	}

	public void setNext(TransactionNode next) {
		this.next = next;
	}

	public TransactionNode getPrevious() {
		return previous;
	}

	public void setPrevious(TransactionNode previous) {
		this.previous = previous;
	}

}
