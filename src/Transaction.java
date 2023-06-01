
public class Transaction {
	private int transactionID;
	private double totalPrice;
	private OrderList orderList = new OrderList();
	private Transaction next;
	private Transaction previous;

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderList getOrderList() {
		return orderList;
	}

	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}

	public Transaction getNext() {
		return next;
	}

	public void setNext(Transaction next) {
		this.next = next;
	}

	public Transaction getPrevious() {
		return previous;
	}

	public void setPrevious(Transaction previous) {
		this.previous = previous;
	}

}
