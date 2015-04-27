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
public void remove(int id){
	int count = 0;
	while(cart.get(count)!=null){
		if(cart.get(count).getId()==id){
			cart.remove(count);
			break;
		}
		else{
			count++;
		}
	}
}
public Product getId(int id){
	int count = 0;
	
	while(cart.get(count)!=null){
		if(cart.get(count).getId()==id){
			return cart.get(count);
		}
		else{
			count++;
		}
	}
	return cart.get(0);
}
}
