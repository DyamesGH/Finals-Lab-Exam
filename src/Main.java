
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
			try {
				/*
				 * Main menu of the program. Each functions in the switch cases are placed on
				 * their own methods to increase readability. Each cases corresponds to a
				 * function call to do the operations.
				 */
				System.out.println("\n-----Inventory-----");
				System.out.println("[1] Display Items");
				System.out.println("[2] Add New Item");
				System.out.println("[3] Replenish Stock");
				System.out.println("-------Sales-------");
				System.out.println("[4] Transact Order");
				System.out.println("[5] Generate Report");
				System.out.println("-------Exit--------");
				System.out.println("[6] Exit");

				System.out.print("Enter command: ");
				int command = Integer.parseInt(reader.readLine());

				switch (command) {
				case 1:
					System.out.println("----------Inventory Display----------");
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
					System.out.print("\n--Exit--" + "\nProgram will be terminated");
					for (int i = 0; i < 3; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.print("\nProgram terminated.");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input.");
					break;

				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}

		}

	}

	/*
	 * Adds an item into the inventory. Asks the user for item description, price,
	 * and initial stock count.
	 */
	public static void addItem() throws IOException {
		try {
			System.out.print("\nEnter the description of the new item: ");
			String description = reader.readLine();
			System.out.print("Enter the price of the new item: ");
			int price = Integer.parseInt(reader.readLine());
			System.out.print("Enter the initial stock: ");
			int stock = Integer.parseInt(reader.readLine());
			Item newItem = new Item(ItemList.getItemIdCounter(), description, price, stock);
			itemList.add(new ItemNode(newItem));
			System.out.print("The new item has been added successfully!\n");
		} catch (Exception e) {
			System.out.println("Invalid input.");
		}

	}

	/*
	 * Replenishes stock of the selected item. Operation cannot be done if there are
	 * no items yet in the inventory. Ask the user for the item's ID, if the item
	 * does not exist the operation will be cancelled. If it is found, the user will
	 * be asked to input a stock value. A positive number to increase the stock, and
	 * a negative value to decrease the stock.
	 */
	public static void replenishStock() throws NumberFormatException, IOException {
		if (!itemList.haveItem()) {
			return;
		}

		try {
			System.out.println("----------Replenishing Stock----------");
			itemList.displayItems();
			if (itemList.getHead() == null) {
				System.out.println("There are no items in the inventory.");
			} else {
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
		} catch (Exception e) {
			System.out.println("Invalid input.");
		}

	}

	/*
	 * The method for performing a transacting operation. The item is first searched
	 * if it exists or if the item has any stocks left. The item cannot be under
	 * transaction if it does not exist or if it does not have any stocks left.
	 * 
	 * 
	 * The user will be prompted on how many will they order. After every
	 * transaction the sub total will be shown and they will be asked if they want
	 * to do another transaction.
	 * 
	 * When the user refused to do any more transactions, the total of the
	 * transaction will be displayed. When the user has already ordered all of the
	 * items in the inventory, they won't be able to order anymore and their orders
	 * will be totaled.
	 */
	public static void transactOrder() throws NumberFormatException, IOException {
		if (!itemList.haveItem()) {
			return;
		} else if (!itemList.ifItemsHaveStocks()) {
			System.out.println("\n--There are no more items with stocks. Please replenish the inventory.--");
			return;
		}


		boolean cont = true;
		Transaction newTransaction = new Transaction();
		orderList = new OrderList();
		double orderSubTotal = 0.00;
		double transactionTotal = 0.00;

		while (cont) {
			try {
				System.out.println("\n----------Order Transaction----------");
				itemList.displayItems();
				System.out.println("\nTransaction ID: " + transactionList.getTransactionID());
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
				System.out.printf("Subtotal: P %,.2f %n", orderSubTotal);
				transactionTotal += orderSubTotal;
				orderList.addOrder(id, quantity, orderSubTotal);

				orderSubTotal = 0;
				if (itemList.ifItemsHaveStocks() == true) {
					char choice;
					while(true) {
						System.out.print("Do you wish to add another item y/n? ");
						choice = reader.readLine().charAt(0);
						if(choice == 'n') {
							cont = false;
							break;
						}else if (choice == 'y') {
							cont = true;
							break;
						}else {
							System.out.println("Invalid input.\n");
						}
					}
					if(choice == 'y') {
						continue;
					}
				} else {
					cont = false;
				}
				System.out.printf("%nTotal Price: P %,.2f %n", transactionTotal);
				System.out.println("Transaction recorded!");

				newTransaction.setOrderList(orderList);
				newTransaction.setTotalPrice(transactionTotal);

				transactionList.addTransaction(newTransaction);
				if (itemList.ifItemsHaveStocks() == false) {
					System.out.println("\n--There are no more items with stocks. Please replenish the inventory.--");
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid input.");
			}
		}
	}

	/*
	 * Generates reports of the past transactions. A prompt will be shown if there
	 * are no transaction that occurred yet. The report shows all of the
	 * transactions that occurred sorted by their ID. Each report consists of all
	 * details of the transactions that occurred. Per transactions, it shows the
	 * product description, its price multiplied by the quantity ordered, the sub
	 * total of the product ordered, and the total of the transaction. At the
	 * bottom, the total sales is displayed amounting to the total of all the
	 * transactions that have occurred.
	 */
	public static void generateReport() {
		if (transactionList.getHead() == null) {
			System.out.println("There are no transactions yet.");
		} else {
			Transaction transaction = transactionList.getHead();
			double totalSales = 0;

			System.out.println("\n----------Transactions Report----------");
			while (transaction != null) {
				System.out.println("\nTransaction ID: " + transaction.getTransactionID());
				transaction.getOrderList().displayOrders(itemList);
				System.out.printf("Total: P %,.2f %n", transaction.getTotalPrice());
				totalSales += transaction.getTotalPrice();
				transaction = transaction.getNext();
			}

			System.out.printf("%nTotal Sales: P %,.2f%n", totalSales);
		}

	}

}
