
/*
 * This class acts as the items Themselves.
 */
public class Item {

	private int id;
	private String description;
	private double price;
	private int stock;

	//Constructor
	public Item(int id, String desc, int price, int stock) {
		this.id = id;
		this.description = desc;
		this.price = price;
		this.stock = stock;
	}

	//Setters getters
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
