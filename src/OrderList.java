
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

	public void displayOrders(ItemList itemList) {
		OrderNode temp = head;

		while (temp != null) {
			
			System.out.printf("%-20s%,10.2f  x  %,-20dP%,.2f %n",itemList.getItem(temp.getItemID()).getDescription(),itemList.getItem(temp.getItemID()).getPrice()
					,temp.getQuantity(),temp.getPrice());
//			System.out.println(itemList.getItem(temp.getItemID()).getDescription() + "\t\t"
//					+ (itemList.getItem(temp.getItemID()).getPrice()) + " x " + temp.getQuantity() + "\t\tP"
//					+ temp.getPrice());
			temp = temp.getNext();
		}
	}

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