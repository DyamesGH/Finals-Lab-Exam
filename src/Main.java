import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
		static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		static ItemList itemList = new ItemList();
	
	 public static void main(String[] args) throws NumberFormatException, InterruptedException, IOException {
		 while(true) {
			 
			 
			 System.out.println("[1] Display Items");
			 System.out.println("[2] Add New Item");
			 System.out.println("[3] Replenish Stock");
			 System.out.println("[4] Transact Order");
			 System.out.println("[5] Generate Report");
			 System.out.println("[6] Exit");
			 
			 System.out.print("Enter command: ");
			 int command = Integer.parseInt(reader.readLine());
			 
			 switch(command) {
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
				 break;
			 case 5:
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
		 Item newItem = new Item(ItemList.getItemIdCounter(), description, price, stock );
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
	
}
