/*
 * This class is a list used to store the items that the users have ordered.
 */
public class OrderList {
	private OrderNode head;
	private OrderNode tail;

	public OrderNode getHead() {
		return head;
	}

	public void setHead(OrderNode head) {
		this.head = head;
	}

	public OrderNode getTail() {
		return tail;
	}

	public void setTail(OrderNode tail) {
		this.tail = tail;
	}

	/*
	 * Adds an order in the order in the order list.
	 */
	public void addOrder(int itemID, int quantity, double price) {
		OrderNode newOrder = new OrderNode(itemID, quantity, price);

		if (head == null) {
			this.head = newOrder;
			tail = head;

		} else {
			tail.setNext(newOrder);
			tail = tail.getNext();
		}
	}

	//Displays all of the orders.
	public void displayOrders(ItemList itemList) {
		OrderNode temp = head;

		while (temp != null) {
			
			System.out.printf("%-20s%,10.2f  x  %,-20dP%,.2f %n",itemList.getItem(temp.getItemID()).getDescription(),itemList.getItem(temp.getItemID()).getPrice()
					,temp.getQuantity(),temp.getPrice());
			temp = temp.getNext();
		}
	}

	//Checks if an order exists.
	public boolean orderExist(int id) {
		OrderNode temp = head;

		while (temp != null) {
			if (temp.getItemID() == id) {
				return true;
			}
			temp = temp.getNext();
		}

		return false;
	}
}