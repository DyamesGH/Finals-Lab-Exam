/*
 * This class is used to store the transactions that have occured.
 */
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

	//Adds a transactions in the list
	public void addTransaction(Transaction newTransaction) {
		newTransaction.setTransactionID(transactionID);

		if (head == null) {
			head = newTransaction;
			tail = head;
		} else {
			newTransaction.setPrevious(tail);
			tail.setNext(newTransaction);
			tail = tail.getNext();
		}

		transactionID++;
	}

}
