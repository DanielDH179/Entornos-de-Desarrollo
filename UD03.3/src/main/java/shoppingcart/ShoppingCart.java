package shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
	
	/* Añadido el tipo genérico de la clase Product */
	private ArrayList<Product> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	
	public double getBalance() {
		double balance = 0;
		for (Iterator<Product> i = items.iterator(); i.hasNext();){
			Product item = (Product) i.next();
			balance += item.getPrice();
		}
		return balance;
	}
	
	public void addItem(Product item) {
		items.add(item);
	}
	
	public void removeItem(Product item) throws ProductNotFoundException {
		if (!items.remove(item))
			throw new ProductNotFoundException();
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	public void empty() {
		items.clear();
	}
	
}