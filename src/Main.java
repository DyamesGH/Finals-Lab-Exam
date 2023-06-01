
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static ItemList itemList = new ItemList();
	static OrderList orderList;
	static TransactionList transactionList = new TransactionList();

	public static void main(String[] args) throws NumberFormatException, InterruptedException, IOException {
		while (true) {

			System.out.println("\n[1] Display Items");
			System.out.println("[2] Add New Item");
			System.out.println("[3] Replenish Stock");
			System.out.println("[4] Transact Order");
			System.out.println("[5] Generate Report");
			System.out.println("[6] Exit");

			System.out.print("Enter command: ");
			int command = Integer.parseInt(reader.readLine());

			switch (command) {
			case 1:
				itemList.displayItems();
				break;
			case 2:
				addItem();
				break;
			case 3:
				replenishStock();
				break;
			case 4:
				transactOrder();
				break;
			case 5:
				generateReport();
				break;
			case 6:
				break;

			}

		}

	}

	public static void addItem() throws IOException {
		System.out.print("\nEnter the description of the new item: ");
		String description = reader.readLine();
		System.out.print("Enter the price of the new item: ");
		int price = Integer.parseInt(reader.readLine());
		System.out.print("Enter the initial stock: ");
		int stock = Integer.parseInt(reader.readLine());
		Item newItem = new Item(ItemList.getItemIdCounter(), description, price, stock);
		itemList.add(new ItemNode(newItem));
		System.out.print("The new item has been added successfully!\n");

	}

	public static void replenishStock() throws NumberFormatException, IOException {
		System.out.print("Select an item by entering its ID: ");
		int ID = Integer.parseInt(reader.readLine());
		Item item = itemList.getItem(ID);
		if (item == null) {
			System.out.println("Item is not found!");
		} else {
			System.out.print("Number of stocks to be added: ");
			int addedStocks = Integer.parseInt(reader.readLine());
			item.setStock(item.getStock() + addedStocks);
			System.out.println("\nUpdate Successfull!");
		}

	}

	public static void transactOrder() throws NumberFormatException, IOException {
		boolean cont = true;
		TransactionNode newTransaction = new TransactionNode();
		orderList = new OrderList();
		int orderSubTotal = 0;
		int transactionTotal = 0;
		itemList.displayItems();

		System.out.println("\nTransaction ID: " + transactionList.getTransactionID());

		while (cont) {
			System.out.print("\nEnter Item ID: ");
			int id = Integer.parseInt(reader.readLine());

			if (orderList.orderExist(id) == true) {
				System.out.println("The item is already in the list. Select another item.");
				continue;
			} else if (itemList.getItem(id) == null) {
				System.out.println("Item is not available. Please try again.");
				continue;
			} else if (itemList.getItem(id).getStock() <= 0) {
				System.out.println("Item is out of stock. Please try again.");
				continue;
			}

			System.out.print("How many " + itemList.getItem(id).getDescription() + "? ");
			int quantity = Integer.parseInt(reader.readLine());
			if (itemList.getItem(id).getStock() < quantity) {
				System.out.println("Not enought stocks. Please try again.");
				continue;
			} else {
				itemList.getItem(id).setStock(itemList.getItem(id).getStock() - quantity);
			}

			orderSubTotal = itemList.getItem(id).getPrice() * quantity;
			System.out.println("Subtotal: P " + orderSubTotal);
			transactionTotal += orderSubTotal;
			orderList.addOrder(id, quantity, orderSubTotal);

			orderSubTotal = 0;

			System.out.print("Do you wish to add another item y/n? ");
			char choice = reader.readLine().charAt(0);
			cont = choice == 'n' ? false : true;
		}

		System.out.println("\nTotal Price: " + transactionTotal);
		System.out.println("Transaction recorded!");

		newTransaction.setOrderList(orderList);
		newTransaction.setTotalPrice(transactionTotal);

		transactionList.addTransaction(newTransaction);
	}

	public static void generateReport() {
		TransactionNode temp = transactionList.getHead();
		double totalSales = 0;

		while (temp != null) {
			System.out.println("Transaction ID: " + temp.getTransactionID());
			temp.getOrderList().displayOrders(itemList);
			System.out.println("Total:\t\t\t\t\tP" + temp.getTotalPrice() + "\n");
			totalSales += temp.getTotalPrice();
			temp = temp.getNext();
		}

		System.out.println("Total Sales: P " + totalSales);

	}

}
