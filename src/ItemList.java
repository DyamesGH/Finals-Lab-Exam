
public class ItemList {

	private ItemNode head;
	private ItemNode tail;
	private static int itemIdCounter;

	public ItemList() {
		head = null;
		tail = null;
		itemIdCounter = 1;
	}

	public static int getItemIdCounter() {
		return itemIdCounter;
	}
	public ItemNode getHead() {
		return head;
	}

	public void add(ItemNode node) {
		if (head == null) {

			head = node;
			tail = node;
			itemIdCounter++;

		} else {

			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
			itemIdCounter++;
		}
	}

	public void displayItems() {
		System.out.printf("%-25s %-25s %-25s %-25s %n", "Item ID", "Description", "Price", "Stock");
		ItemNode currentNode = head;
		while (currentNode != null) {
			System.out.printf("%-25d %-25s %-,25.2f %,-25d %n", currentNode.getData().getId(),
					currentNode.getData().getDescription(), currentNode.getData().getPrice(),
					currentNode.getData().getStock());
			currentNode = currentNode.getNext();
		}
	}

	public Item getItem(int id) {
		ItemNode currentNode = head;

		while (currentNode != null) {
			if (currentNode.getData().getId() == id) {
				return currentNode.getData();
			}
			currentNode = currentNode.getNext();
		}
		return null;
	}

}
