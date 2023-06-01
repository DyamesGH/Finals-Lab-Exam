
public class TransactionList {
	private int transactionID = 1;
	private Transaction head;
	private Transaction tail;

	public Transaction getHead() {
		return head;
	}

	public void setHead(Transaction head) {
		this.head = head;
	}

	public Transaction getTail() {
		return tail;
	}

	public void setTail(Transaction tail) {
		this.tail = tail;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void addTransaction(Transaction newTransaction) {
		newTransaction.setTransactionID(transactionID);

		if (head == null) {
			head = newTransaction;
			tail = head;
		} else {
			tail.setNext(newTransaction);
			tail = tail.getNext();
		}

		transactionID++;
	}

}
