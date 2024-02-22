package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCuentaMovimiento {
	
	// Sesión de cobertura del 96,9% para Cuenta
	// Sesión de cobertura del 75,9% para Movimiento
	Cuenta cuenta;
	Movimiento mov;
	
	@BeforeEach
	void init() {
		cuenta = new Cuenta("123456789", "Daniel");
	}
	
	@AfterEach
	void finish() {
		cuenta = null;
	}
	
	@ParameterizedTest(name = "Ingresar {0}€")
	@ValueSource(doubles = {0D, 50D, 100D, -100D})
	void testIngresarDinero(double cantidad) {
		try {
			cuenta.ingresar(cantidad);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@ParameterizedTest(name = "Retirar {0}€")
	@ValueSource(doubles = {0D, 50D, 100D, -100D})
	void testRetirarDinero(double cantidad) {
		try {
			cuenta.ingresar(80D);
			assertThat(cuenta.mMovimientos.size(), is(1));
			cuenta.retirar(cantidad);
			assertThat(cuenta.mMovimientos.size(), is(2));
			assertEquals(cuenta.mMovimientos.get(1).getImporte(), -cantidad);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@ParameterizedTest(name = "{0} con {1}€")
	@MethodSource("ingresosConceptos")
	void testIngresarDineroConConcepto(String concepto, double cantidad) {
		try {
			cuenta.ingresar(concepto, cantidad);
		} catch (Exception ex) {
			System.out.println(concepto + ": " + ex.getMessage());
		}
	}
	
	@ParameterizedTest(name = "{0} con {1}€")
	@MethodSource("retiradasConceptos")
	void testRetirarDineroConConcepto(String concepto, double cantidad) {
		try {
			cuenta.ingresar(80D);
			assertThat(cuenta.mMovimientos.size(), is(1));
			cuenta.retirar(concepto, cantidad);
			assertThat(cuenta.mMovimientos.size(), is(2));
			assertEquals(cuenta.mMovimientos.get(1).getConcepto(), concepto);
		} catch (Exception ex) {
			System.out.println(concepto + ": " + ex.getMessage());
		}
	}
	
	static Stream<Arguments> ingresosConceptos() {
        return Stream.of(
    		Arguments.of("Ingreso A", 0D),
    		Arguments.of("Ingreso B", 50D),
    		Arguments.of("Ingreso C", 100D),
    		Arguments.of("Ingreso D", -100D)
    	);
    }
	
	static Stream<Arguments> retiradasConceptos() {
        return Stream.of(
    		Arguments.of("Retirada A", 0D),
    		Arguments.of("Ingreso B", 50D),
    		Arguments.of("Ingreso C", 100D),
    		Arguments.of("Retirada D", -100D)
    	);
    }

}