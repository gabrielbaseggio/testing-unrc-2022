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

}
