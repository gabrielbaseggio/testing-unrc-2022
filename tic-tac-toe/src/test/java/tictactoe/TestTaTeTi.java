package tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
