package models;
/**
 * This class allows you to create an Article object.
 *
 * @author Sèverine DIRIBARNE
 * @version 1.0
 * @since 1.0
 */

public class Article {

	private int Id;
	private String description;
	private String brand;
	private Double price;
	
	/**
	 * Default constructor with all parameters
	 * 
	 * @param id
	 * @param description
	 * @param brand
	 * @param price
	 */
	public Article(int id, String description, String brand, Double price) {
		super();
		Id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}

	/**
	 * Returns the ID of the Article object.
	 * 
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * Receives the ID to be saved
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * Returns the description of the Article object.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Receives the description to be saved.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the brand (marque) of the Article object.
	 * 
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Receives the brand to be saved.
	 * 
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Returns the price of the Article object.
	 * 
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Receives the price to be saved.
	 * 
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * ToString Method to display each fields of the article 
	 * 
	 */
	@Override
	public String toString() {
		return "Article [Id=" + Id + ", description=" + description + ", brand=" + brand + ", price=" + price + "]";
	}
}
