package tictactoe;

public class TaTeTi {
	
	private Tablero tablero;
	private Ficha jugadorActual;
	private boolean juegoIniciado;

	public void iniciarJuego() {
		tablero       = new Tablero();
		juegoIniciado = true;
		// Inicializar tablero
	}

	public boolean tableroVacio() {
		return tablero.esVacio();
	}

	public void jugarEn(int x, int y) {
		// Saber cual es el jugador actual y con que ficha juega
		tablero.ponerFicha(jugadorActual(), x, y);
		if( jugadorActual.equals( Ficha.X ) ) {
			jugadorActual = Ficha.O;
		} else {
			jugadorActual = Ficha.X;
		}
	}

	public Ficha jugadorActual() {
		return jugadorActual;
	}

	public void jugadorInicial(Ficha jugador) {
		jugadorActual = jugador;
	}

	public Ficha ficha(int x, int y) {
		return tablero.ficha( x, y );
	}

	public boolean termino() {
		if( tablero.ficha(0, 0) != null && tablero.ficha(0, 0).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(2, 2) ) ) return true;
		if( tablero.ficha(0, 2) != null && tablero.ficha(0, 2).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(2, 0) ) ) return true;
		
		//if( tablero.ficha(0, 0) != null && tablero.ficha(0, 0).equals( tablero.ficha(0, 1) ) && tablero.ficha(0, 1).equals( tablero.ficha(0, 2) ) ) return true;
		//if( tablero.ficha(1, 0) != null && tablero.ficha(1, 0).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(1, 2) ) ) return true;
		//refactorizacion
		for( int row = 0; row < 3; row++ ) {
			if( tablero.ficha(row, 0) != null && tablero.ficha(row, 0).equals( tablero.ficha(row, 1) ) && tablero.ficha(row, 1).equals( tablero.ficha(row, 2) ) ) return true;
		}
		
		//if( tablero.ficha(0, 0) != null && tablero.ficha(0, 0).equals( tablero.ficha(1, 0) ) && tablero.ficha(1, 0).equals( tablero.ficha(2, 0) ) ) return true;
		//if( tablero.ficha(0, 1) != null && tablero.ficha(0, 1).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(2, 1) ) ) return true;
		//refactorizacion
		for( int col = 0; col < 3; col++ ) {
			if( tablero.ficha(0, col) != null && tablero.ficha(0, col).equals( tablero.ficha(1, col) ) && tablero.ficha(1, col).equals( tablero.ficha(2, col) ) ) return true;
		}
		
		return tablero.lleno();
	}

	public Ficha ganador() {
		if( tablero.ficha(0, 0) != null && tablero.ficha(0, 0).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(2, 2) ) ) return tablero.ficha(0, 0);
		if( tablero.ficha(0, 2) != null && tablero.ficha(0, 2).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(2, 0) ) ) return tablero.ficha(2, 0);
		
		if( tablero.ficha(0, 0) != null && tablero.ficha(0, 0).equals( tablero.ficha(0, 1) ) && tablero.ficha(0, 1).equals( tablero.ficha(0, 2) ) ) return tablero.ficha(0, 0);
		if( tablero.ficha(1, 0) != null && tablero.ficha(1, 0).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(1, 2) ) ) return tablero.ficha(1, 0);
		
		return null;
	}

}
