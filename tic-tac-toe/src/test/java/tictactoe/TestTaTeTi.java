package tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestTaTeTi {
	@Test
	void jugadorActual1() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		assertEquals( tateti.jugadorActual(), Ficha.X );
	}
	
	@Test
	void jugadorActual2() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 0);
		assertEquals( tateti.jugadorActual(), Ficha.O );
	}
	
	@Test
	void jugadorActual3() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 0);
		tateti.jugarEn(0, 1);
		assertEquals( tateti.jugadorActual(), Ficha.X );
	}
	
	@Test
	void terminoTest1() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 0);
		tateti.jugarEn(0, 1);
		tateti.jugarEn(1, 1);
		tateti.jugarEn(0, 2);
		tateti.jugarEn(2, 2);
		/**
		 * |X|O|O|
		 * | |X| |
		 * | | |X|
		 */
		assertTrue( tateti.termino() );
	}
	
	@Test
	void terminoTest2() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 2);
		tateti.jugarEn(0, 1);
		tateti.jugarEn(1, 1);
		tateti.jugarEn(0, 0);
		tateti.jugarEn(2, 0);
		/**
		 * |O|O|X|
		 * | |X| |
		 * |X| | |
		 */
		assertTrue( tateti.termino() );
	}
	
	@Test
	void terminoTest3() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 0);
		tateti.jugarEn(1, 1);
		tateti.jugarEn(0, 1);
		tateti.jugarEn(1, 2);
		tateti.jugarEn(0, 2);
		/**
		 * |X|X|X|
		 * | |O|O|
		 * | | | |
		 */
		assertTrue( tateti.termino() );
	}
	
	@Test
	void terminoTest4() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(1, 0);
		tateti.jugarEn(0, 1);
		tateti.jugarEn(1, 1);
		tateti.jugarEn(0, 2);
		tateti.jugarEn(1, 2);
		/**
		 * | |O|O|
		 * |X|X|X|
		 * | | | |
		 */
		assertTrue( tateti.termino() );
	}
	
	@Test
	void terminoTest5() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 0);
		tateti.jugarEn(0, 1);
		tateti.jugarEn(1, 0);
		tateti.jugarEn(0, 2);
		tateti.jugarEn(2, 0);
		/**
		 * |X|O|O|
		 * |X| | |
		 * |X| | |
		 */
		assertTrue( tateti.termino() );
	}
	
	@Test
	void terminoTest6() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 1);
		tateti.jugarEn(0, 0);
		tateti.jugarEn(1, 1);
		tateti.jugarEn(1, 0);
		tateti.jugarEn(2, 1);
		/**
		 * |O|X| |
		 * |O|X| |
		 * | |X| |
		 */
		assertTrue( tateti.termino() );
	}
	
	@Test
	void terminoTest7() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 0); //X
		tateti.jugarEn(0, 1); //O
		tateti.jugarEn(0, 2); //X
		tateti.jugarEn(1, 1); //O
		tateti.jugarEn(1, 0); //X
		tateti.jugarEn(2, 0); //O
		tateti.jugarEn(1, 2); //X
		tateti.jugarEn(2, 2); //O
		tateti.jugarEn(2, 1); //X
		/**
		 * |X|O|X|
		 * |X|O|X|
		 * |O|X|O|
		 */
		assertTrue( tateti.termino() );
	}
	
	@Test
	void ganador1() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 2);
		tateti.jugarEn(0, 0);
		tateti.jugarEn(1, 1);
		tateti.jugarEn(0, 1);
		tateti.jugarEn(2, 0);
		assertEquals( tateti.ganador(), Ficha.X );
	}
	
	@Test
	void ganador2() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.X );
		tateti.jugarEn(0, 0);
		tateti.jugarEn(0, 1);
		tateti.jugarEn(1, 1);
		tateti.jugarEn(0, 2);
		tateti.jugarEn(2, 2);
		assertEquals( tateti.ganador(), Ficha.X );
	}
	
	@Test
	void ganador3() {
		TaTeTi tateti = new TaTeTi();
		tateti.iniciarJuego();
		tateti.jugadorInicial( Ficha.O );
		tateti.jugarEn(0, 0);
		tateti.jugarEn(1, 1);
		tateti.jugarEn(0, 1);
		tateti.jugarEn(1, 2);
		tateti.jugarEn(0, 2);
		assertEquals( tateti.ganador(), Ficha.O );
	}
}
