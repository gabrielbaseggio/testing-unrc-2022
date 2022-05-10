package tictactoe;

public class TaTeTi {
	
	private Tablero tablero;
	private Ficha jugadorActual;
	private Ficha ganador;

	public void iniciarJuego() {
		tablero = new Tablero();
	}

	public boolean tableroVacio() {
		return tablero.esVacio();
	}

	public boolean jugarEn(int x, int y) {
		if( x < 0 || x > 2 || y < 0 || y > 2 || tablero.ficha(x, y) != null ) return false;
		tablero.ponerFicha(jugadorActual(), x, y);
		if( jugadorActual.equals( Ficha.X ) ) {
			jugadorActual = Ficha.O;
		} else {
			jugadorActual = Ficha.X;
		}
		
		return true;
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
		return ganador() != null || tablero.lleno();
	}

	public Ficha ganador() {
		
		if( tablero.ficha(0, 0) != null && tablero.ficha(0, 0).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(2, 2) ) ) {
			ganador = tablero.ficha(0, 0);
		}
		
		if( tablero.ficha(0, 2) != null && tablero.ficha(0, 2).equals( tablero.ficha(1, 1) ) && tablero.ficha(1, 1).equals( tablero.ficha(2, 0) ) ) {
			ganador = tablero.ficha(0, 2);
		}
		
		for( int row = 0; row < 3; row++ ) {
			if( tablero.ficha(row, 0) != null && tablero.ficha(row, 0).equals( tablero.ficha(row, 1) ) && tablero.ficha(row, 1).equals( tablero.ficha(row, 2) ) ) {
				ganador = tablero.ficha(row, 0);
			}
		}
		
		for( int col = 0; col < 3; col++ ) {
			if( tablero.ficha(0, col) != null && tablero.ficha(0, col).equals( tablero.ficha(1, col) ) && tablero.ficha(1, col).equals( tablero.ficha(2, col) ) ) {
				ganador = tablero.ficha(0, col);
			}
		}
		
		return ganador;
	}

	public boolean cargarJuego(Tablero tablero, Ficha jugadorActual) {
		if( Math.abs(tablero.nroDeXs() - tablero.nroDeOs()) > 1  ) return false;
		if( tablero.nroDeXs() > tablero.nroDeOs() && jugadorActual.equals( Ficha.X ) ) return false;
		if( tablero.nroDeOs() > tablero.nroDeXs() && jugadorActual.equals( Ficha.O ) ) return false;
		this.tablero       = tablero;
		this.jugadorActual = jugadorActual;
		return true;
	}

	public Tablero tablero() {
		return tablero;
	}

}
