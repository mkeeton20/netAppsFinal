package model;

public class Product {

private int id;
private String name;
private double price;
private int quant;
private String description;
private String img;


	public Product(){
		id = 0;
		name = "";
		price = 0;
		quant = 0;
		description = "";
		img = "";
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Product(String pName, double pPrice, int pQuant, String pDescription, String pimg){
		id = 0;
		name = pName;
		price = pPrice;
		quant = pQuant;
		description = pDescription;
		img = pimg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
}
