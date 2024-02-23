package dominio;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class TestCredito {
	
	// Sesión de cobertura del 0% para Credito
	Credito credito;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void init() {
		credito = new Credito("1", "Juan", new Date(2024, 1, 1), 200D);
	}
	
	@AfterEach
	void finish() {
		credito = null;
	}

}
