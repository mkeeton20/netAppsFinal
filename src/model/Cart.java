package model;

import java.util.ArrayList;

public class Cart {
	
private ArrayList<Product> cart = new ArrayList();
	
public Cart(){
		
	}

public ArrayList<Product> getCart() {
	return cart;
}

public void setCart(ArrayList<Product> cart) {
	this.cart = cart;
}
public void add(Product product){
	this.cart.add(product);
	
}
}
