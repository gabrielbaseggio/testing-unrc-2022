package tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestTablero {

	@Test
	void crearTableroInicial() {
		Tablero t = new Tablero();
		assertTrue(t.esVacio());
	}
	
	@Test
	void crearTableroNoVacio() {
		Tablero t = new Tablero();
		t.ponerFicha(Ficha.X, 1, 1);
		assertFalse(t.esVacio());
	}
	
	@Test
	void ponerFichaSobreFicha() {
		Tablero t = new Tablero();
		t.ponerFicha(Ficha.X, 1, 1);
		assertThrows(IllegalArgumentException.class, 
				()->t.ponerFicha(Ficha.O, 1, 1));
	}
	
	@Test
	void llenoTest() {
		Tablero t = new Tablero();
		t.ponerFicha(Ficha.X, 0, 0);
		t.ponerFicha(Ficha.O, 0, 1);
		t.ponerFicha(Ficha.X, 0, 2);
		t.ponerFicha(Ficha.O, 1, 0);
		t.ponerFicha(Ficha.X, 1, 1);
		t.ponerFicha(Ficha.O, 1, 2);
		t.ponerFicha(Ficha.O, 2, 0);
		t.ponerFicha(Ficha.X, 2, 1);
		t.ponerFicha(Ficha.O, 2, 2);
		assertTrue( t.lleno() );
	}
	
	@ParameterizedTest
	@CsvSource({
		"0,0,false",
		"1,0,true"
	})
	void hayFichaEnLaPosicion( int i, int j, boolean expected ) {
		Tablero t = new Tablero();
		t.ponerFicha(Ficha.O, 1, 0);
		t.ponerFicha(Ficha.X, 1, 1);
		t.ponerFicha(Ficha.O, 1, 2);
		t.ponerFicha(Ficha.O, 2, 0);
		t.ponerFicha(Ficha.X, 2, 1);
		t.ponerFicha(Ficha.O, 2, 2);
		assertEquals( t.hayFichaEnLaPosicion( i, j ), expected );
	}
	
	@ParameterizedTest
	@CsvSource({
		"0,2,X"
	})
	void ficha( int x, int y, Ficha expected ) {
		Tablero t = new Tablero();
		t.ponerFicha(Ficha.X, 0, 2);
		t.ponerFicha(Ficha.O, 1, 2);
		assertEquals( t.ficha(x, y), expected );
	}
}
