/*
 * Acts as the *inventory* of the items.
 */
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

	//Adds an ItemNode in the list
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

	/*
	 * Displays the items in the list in a specific format
	 */
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

	/*
	 * Used to search for an item in the list.
	 * Returns the item if it is found, returns null if it not found.
	 */
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
