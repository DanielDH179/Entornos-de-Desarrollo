package shoppingcart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestShoppingCart {

	private ShoppingCart sc;
	private Product item;
	
	@BeforeEach
	void init() {
		sc = new ShoppingCart();
		item = new Product("Headphones", 20);
	}
	
	@AfterEach
	void finish() {
		sc = null;
		item = null;
	}
	
	/* Cuando se crea, el carro tiene 0 elementos */
	@Test
	void testIsEmptyAfterInitialization() {
		assertThat(sc.getItemCount(), is(0));
	}
	
	/* Cuando esté vacío, el carro tiene 0 elementos */
	@Test
	void testIsEmptyAfterClearingItems() {
		sc.empty();
		assertEquals(sc.getItemCount(), 0);
	}
	
	/* Cuando se añade un producto, el número de elementos
	 * debe incrementarse */
	@Test
	void testIncrementAfterNewItem() {
		sc.addItem(item);
		assertTrue(sc.getItemCount() == 1);
	}
	
	/* Cuando se añade un producto, el balance nuevo debe
	 * ser la suma del balance anterior y el precio del
	 * producto añadido */
	@Test
	void testNewBalanceAfterNewItem() {
		double before = sc.getBalance();
		sc.addItem(item);
		assertThat(sc.getBalance(), is(before + item.getPrice()));
	}
	
	/* Cuando se elimina un producto, el número de
	 * elementos debe decrementarse */
	@Test
	void testDecrementAfterRemovedItem() throws ProductNotFoundException {
		sc.addItem(item);
		sc.removeItem(item);
		assertThat(sc.getItemCount(), is(0));
	}
	
	/* Cuando se intenta eliminar un producto que no
	 * está en el carro, se debe lanzar una excepción
	 * ProductNotFoundException. Pista: inserta la
	 * llamada en un bloque try y pon un método fail()
	 * después de la llamada a removeItem() */
	@Test
	void testProductNotFound() {
		try {
			sc.removeItem(item);
			fail("The shopping cart is empty");
		}
		catch (ProductNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
}
