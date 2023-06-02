/*
 * Acts as the *inventory* of the items.
 */
public class ItemList {

	private ItemNode head;
	private ItemNode tail;
	private static int itemIdCounter;
	private int size;

	public ItemList() {
		head = null;
		tail = null;
		itemIdCounter = 1;
		size = 0;
	}

	public static int getItemIdCounter() {
		return itemIdCounter;
	}

	public ItemNode getHead() {
		return head;
	}

	public int getSize() {
		return size;
	}

	// Adds an ItemNode in the list
	public void add(ItemNode node) {
		if (head == null) {

			head = node;
			tail = node;
			itemIdCounter++;
			size++;
		} else {

			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
			itemIdCounter++;
			size++;
		}
	}

	/*
	 * Displays the items in the list in a specific format
	 */
	public void displayItems() {
		if (!haveItem()) {
			return;
		}

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
	 * Used to search for an item in the list. Returns the item if it is found,
	 * returns null if it not found.
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

	/*
	 * This method is used to check if the list have items by checking if the lists'
	 * head is null. If it is null then it returns false else it returns true.
	 */
	public boolean haveItem() {
		if (this.head == null) {
			System.out.println("There are no available item. Please add an item first.");
			return false;
		}

		return true;
	}

	/*
	 * This method is used to check if the items in the list still have stocks by
	 * checking each of the items in the list still have stocks. If it finds an item
	 * still have stock it automatically returns true then if the whole list is
	 * traversed but all the items have no stocks then it returns.
	 */
	public boolean haveStocks() {
		ItemNode currentNode = head;

		while (currentNode != null) {
			if (currentNode.getData().getStock() > 0) {
				return true;
			}
			currentNode = currentNode.getNext();
		}

		System.out.println("\n--There are no more items with stocks. Please replenish the inventory.--");
		return false;
	}

}
