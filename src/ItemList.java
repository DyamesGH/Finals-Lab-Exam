
public class ItemList {
	
	private ItemNode head;
	private ItemNode tail;
	private static int itemIdCounter;
	
	public ItemList() {
		head = null;
		tail = null;
		itemIdCounter=1;
	}
	
	public static int getItemIdCounter() {
		return itemIdCounter;
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
	
	public String displayItems() {
		System.out.printf("%-7s %-11s %-5s %-5s %n", "Item ID","Description","Price","Stock");
		ItemNode currentNode = head;
		while(currentNode != null) {
			System.out.printf("%-7d %-11s %-5d  %-5d %n", currentNode.getData().getId(),currentNode.getData().getDescription(),currentNode.getData().getPrice(),currentNode.getData().getStock() );
			currentNode = currentNode.getNext();
		}
		return "";
	}
	
	public Item getItem(int id) {
		ItemNode currentNode = head;
		
		while(currentNode.getData().getId() != id && currentNode.getNext()!=null) {
			if(currentNode.getData().getId() == id) {
				return currentNode.getData();
			}else {
				currentNode = currentNode.getNext();
			}
		}
		return null;
	}

}
