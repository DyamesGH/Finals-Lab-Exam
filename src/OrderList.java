/*
 * This class is a list used to store the items that the users have ordered.
 */
public class OrderList {
	private OrderNode head;
	private OrderNode tail;
	private int size = 0;

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

	public int getSize() {
		return size;
	}

	/*
	 * Adds an order in the order in the order list. If the head is null then the
	 * new node becomes the head of the orderlist then if it is not null then the
	 * new node will be added to the tail extending the list.
	 */
	public void addOrder(int itemID, int quantity, double price) {
		OrderNode newOrder = new OrderNode(itemID, quantity, price);

		if (head == null) {
			this.head = newOrder;
			tail = head;
			size++;

		} else {
			tail.setNext(newOrder);
			tail = tail.getNext();
			size++;
		}
	}

	/*
	 * Displays all of the orders in the order list by traversing the list from the
	 * head to the last node and displaying their properties.
	 */
	public void displayOrders(ItemList itemList) {
		OrderNode temp = head;

		while (temp != null) {

			System.out.printf("%-20s%,10.2f  x  %,-20dP%,.2f %n", itemList.getItem(temp.getItemID()).getDescription(),
					itemList.getItem(temp.getItemID()).getPrice(), temp.getQuantity(), temp.getPrice());
			temp = temp.getNext();
		}
	}

	/*
	 * Checks if an order exists by traversing the whole list and searches the
	 * entered integer argument. If the entered argument is equal to one of the id
	 * of the present order nodes then it return true. And if the whole list is
	 * traversed without satisfying the argument then the method returns false.
	 */
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
