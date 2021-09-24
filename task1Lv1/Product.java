package task1Lv1;

public class Product {

	private double price;
	private String description;
	private double weight;

	public Product(double price, String description, double weight) {
		super();
		this.price = price;
		this.description = description;
		this.weight = weight;
	}

	public Product() {
		super();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return "Product [price=" + price + ", weight=" + weight + ", description=" + description + "]";
	}

}
