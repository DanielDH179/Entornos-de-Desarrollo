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

public class VideojuegoTest {

	private Videojuego videojuego1, videojuego2;

	@BeforeEach
	void iniciar() {
		videojuego1 = new Videojuego();
		videojuego2 = new Videojuego("Fortnite", "Epic Games");
	}
	
	@AfterEach
	void finalizar() {
		videojuego1 = videojuego2 = null;
	}
	
	@Test
	void testNoNulo() {
		assertThat(videojuego1, notNullValue());
		assertThat(videojuego2, notNullValue());
	}
	
	@Test
	void testTitulo() {
		videojuego1.setTitulo("Minecraft");
		assertThat(videojuego1.getTitulo(), is("Minecraft"));
		assertThat(videojuego2.getTitulo(), is("Fortnite"));
	}
	
	@Test
	void testHorasEstimadas() {
		videojuego1.setHorasEstimadas(120);
		assertThat(videojuego1.getHorasEstimadas(), is(120));
		assertThat(videojuego2.getHorasEstimadas(), is(100));
	}
	
	@Test
	void testGenero() {
		videojuego1.setGenero("Sandbox");
		assertThat(videojuego1.getGenero(), is("Sandbox"));
		assertThat(videojuego2.getGenero(), is(""));
	}
	
	@Test
	void testCompania() {
		videojuego1.setCompania("Mojang");
		assertThat(videojuego1.getCompania(), is("Mojang"));
		assertThat(videojuego2.getCompania(), is("Epic Games"));
	}
	
	@Test
	void testEntregado() {
		videojuego1.entregar();
		videojuego2.devolver();
		assertTrue(videojuego1.isEntregado());
		assertFalse(videojuego2.isEntregado());
	}
	
	@Test
	void testDistintasHoras() {
		videojuego1.setHorasEstimadas(110);
		videojuego2.setHorasEstimadas(120);
		assertThat(videojuego1.compareTo(videojuego2), is(Videojuego.MENOR));
		assertThat(videojuego2.compareTo(videojuego1), is(Videojuego.MAYOR));
	}
	
	@Test
	void testMismasHoras() {
		videojuego1.setHorasEstimadas(120);
		videojuego2.setHorasEstimadas(120);
		assertThat(videojuego1.compareTo(videojuego2), is(Videojuego.IGUAL));
	}

	@Test
	void testMismoVideojuego() {
		videojuego1.setTitulo("Fortnite");
		videojuego1.setCompania("Epic Games");
		assertEquals(videojuego1.toString(), videojuego2.toString());
	}
	
	@Test
	void testDistintoVideojuego() {
		assertFalse(videojuego1.equals(videojuego2));
	}

}