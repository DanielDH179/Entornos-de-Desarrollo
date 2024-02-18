package persona;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonaTest {

	// Casos de uso
    private Persona hombre, mujer, otro;
    // Casos de recorrido (+95,5% Coverage)
    private Persona constructorPredeterminado, otroConstructor;

    @BeforeEach
    void iniciar() {
    	hombre = new Persona("Daniel", 22, 'H', 70, 1.75);
    	mujer = new Persona("Noelia", 17, 'M', 50, 1.77);
    	otro = new Persona("Vida", 30, 'X', 60, 1.72);
    	constructorPredeterminado = new Persona();
    	otroConstructor = new Persona("Samuel", 20, 'H');
    }

    @AfterEach
    void finalizar() {
    	hombre = mujer = otro = null;
    	constructorPredeterminado = otroConstructor = null;
    }

    @Test
    void testPersonaCreada() {
    	assertThat(hombre, notNullValue());
    	assertThat(mujer, notNullValue());
    	assertThat(otro, notNullValue());
    	assertThat(constructorPredeterminado, notNullValue());
    	assertThat(otroConstructor, notNullValue());
    }

    @Test
    void testMayorDeEdad() {
        assertTrue(hombre.esMayorDeEdad());
        assertTrue(otro.esMayorDeEdad());
    }
    
    @Test
    void testCambioNombre() {
    	hombre.setNombre("Juan");
    }

    @Test
    void testCambioSexo() {
    	hombre.setSexo('M');
    	hombre.setSexo('X');
    	mujer.setSexo('H');
    }
    
    @Test
    void testMenorDeEdad() {
    	hombre.setEdad(15);
        assertFalse(hombre.esMayorDeEdad());
        assertFalse(mujer.esMayorDeEdad());
    }

    @Test
    void testEdadPositiva() {
        assertDoesNotThrow(() -> hombre.setEdad(50));
    }

    @Test
    void testEdadNegativa() {
        assertThrows(AssertionError.class, () -> hombre.setEdad(-1));
    }

    @Test
    void testPesoIdeal() {
    	assertThat(hombre.calcularIMC(), is(Persona.PESO_IDEAL));
    }

    @Test
    void testInfrapesoNuevoPeso() {
        hombre.setPeso(20);
        assertThat(hombre.calcularIMC(), is(Persona.INFRAPESO));
    }

    @Test
    void testInfrapesoNuevaAltura() {
        hombre.setAltura(2);
        assertThat(hombre.calcularIMC(), is(Persona.INFRAPESO));
    }

    @Test
    void testSobrepesoNuevoPeso() {
        hombre.setPeso(100);
        assertThat(hombre.calcularIMC(), is(Persona.SOBREPESO));
    }

    @Test
    void testSobrepesoNuevaAltura() {
        hombre.setAltura(1.3);
        assertThat(hombre.calcularIMC(), is(Persona.SOBREPESO));
    }

    @Test
    void testFormatoCorrectoDNI() {
        Pattern modelo = Pattern.compile("\\b\\d{8}[A-Z]\\b");
        Matcher buscador = modelo.matcher(hombre.toString());
        assertTrue(buscador.find());
        buscador = modelo.matcher(mujer.toString());
        assertTrue(buscador.find());
        // System.out.println(buscador.group());
    }

}
