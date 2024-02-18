package shoppingcart;

public class ProductNotFoundException extends Exception {
	
	/* Añadido el ID de serie para la excepción */
	private static final long serialVersionUID = 179L;

	public ProductNotFoundException() {
		super();
	}
	
}