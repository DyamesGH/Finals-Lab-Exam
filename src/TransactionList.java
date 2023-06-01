
public class TransactionList {
	private int transactionID = 1;
	private TransactionNode head;
	private TransactionNode tail;

	public TransactionNode getHead() {
		return head;
	}

	public void setHead(TransactionNode head) {
		this.head = head;
	}

	public TransactionNode getTail() {
		return tail;
	}

	public void setTail(TransactionNode tail) {
		this.tail = tail;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void addTransaction(TransactionNode newTransaction) {
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
