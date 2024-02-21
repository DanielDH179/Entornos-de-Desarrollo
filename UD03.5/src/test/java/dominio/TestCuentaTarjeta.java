package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCuentaTarjeta {
	
	Cuenta cuenta;
	
	@BeforeEach
	void init() {
		cuenta = new Cuenta("123456789", "Daniel");
	}
	
	@AfterEach
	void finish() {
		cuenta = null;
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {0D, 100D, -100D})
	void testIngresarDinero() {
		try {
			cuenta.ingresar(100);
		} catch (Exception ex) {
			System.out.println("Ingreso de cantidad negativa");
		}
	}

}
