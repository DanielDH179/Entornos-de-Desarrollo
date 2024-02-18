package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SerieTest {

	private Serie serie1, serie2;
	
	@BeforeEach
	void iniciar() {
		serie1 = new Serie();
		serie2 = new Serie("Star Wars", "George Lucas");
	}
	
	@AfterEach
	void finalizar() {
		serie1 = serie2 = null;
	}
	
	@Test
	void testNoNulo() {
		assertThat(serie1, notNullValue());
		assertThat(serie2, notNullValue());
	}
	
	@Test
	void testTitulo() {
		serie1.setTitulo("Harry Potter");
		assertThat(serie1.getTitulo(), is("Harry Potter"));
		assertThat(serie2.getTitulo(), is("Star Wars"));
	}
	
	@Test
	void testTemporadas() {
		serie1.setNumeroTemporadas(8);
		assertThat(serie1.getNumeroTemporadas(), is(8));
		assertThat(serie2.getNumeroTemporadas(), is(3));
	}
	
	@Test
	void testGenero() {
		serie1.setGenero("Fantasía");
		assertThat(serie1.getGenero(), is("Fantasía"));
		assertThat(serie2.getGenero(), is(""));
	}
	
	@Test
	void testCreador() {
		serie1.setCreador("J.K. Rowling");
		assertThat(serie1.getCreador(), is("J.K. Rowling"));
		assertThat(serie2.getCreador(), is("George Lucas"));
	}
	
	@Test
	void testEntregado() {
		serie1.entregar();
		serie2.devolver();
		assertTrue(serie1.isEntregado());
		assertFalse(serie2.isEntregado());
	}
	
	@Test
	void testDistintasHoras() {
		serie1.setNumeroTemporadas(8);
		serie2.setNumeroTemporadas(9);
		assertThat(serie1.compareTo(serie2), is(Serie.MENOR));
		assertThat(serie2.compareTo(serie1), is(Serie.MAYOR));
	}
	
	@Test
	void testMismasHoras() {
		serie1.setNumeroTemporadas(8);
		serie2.setNumeroTemporadas(8);
		assertThat(serie1.compareTo(serie2), is(Serie.IGUAL));
	}

	@Test
	void testMismaSerie() {
		serie1.setTitulo("Star Wars");
		serie1.setCreador("George Lucas");
		assertEquals(serie1.toString(), serie2.toString());
	}
	
	@Test
	void testDistintaSerie() {
		assertFalse(serie1.equals(serie2));
	}
	
}