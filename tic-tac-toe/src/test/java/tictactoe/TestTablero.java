package tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.LinkedList;

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
	
	@Test
	void ficha( int x, int y ) {
		Tablero t = new Tablero();
		t.ponerFicha(Ficha.X, 0, 2);
		assertEquals( t.ficha(0, 2), Ficha.X );
	}
	
	@Test
	void crearTableroConListaDeListas() {
		List<List<String>> listaDeListas = new LinkedList<>();
		List<String> columnas    = new LinkedList<>();
		columnas.add("X");
		columnas.add("O");
		columnas.add("X");
		listaDeListas.add( columnas );
		listaDeListas.add( columnas );
		listaDeListas.add( columnas );
		Tablero t = new Tablero( listaDeListas );
		assertFalse( t.esVacio() );
	}
	
	@Test
	void tableroEquals1() {
		Tablero t1 = new Tablero();
		Tablero t2 = new Tablero();
		assertTrue( t1.equals( t2 ) );
	}
	
	@Test
	void tableroEquals2() {
		Tablero t1 = new Tablero();
		Tablero t2 = new Tablero();
		t1.ponerFicha(Ficha.X, 0, 0);
		t1.ponerFicha(Ficha.X, 0, 1);
		t1.ponerFicha(Ficha.X, 0, 2);
		t2.ponerFicha(Ficha.X, 0, 0);
		t2.ponerFicha(Ficha.X, 0, 1);
		t2.ponerFicha(Ficha.X, 0, 2);
		assertTrue( t1.equals( t2 ) );
	}
}
