package tictactoe;

import java.util.List;

public class Tablero {
	
	private Ficha[][] tablero  = new Ficha[3][3];
	private int fichas  = 0;
	private int nroDeXs = 0;
	private int nroDeOs = 0;
	
	public Tablero() {}

	public Tablero(List<List<String>> listaDeListas) {
		for( int row = 0; row < 3; row++ ) {
			for( int col = 0; col < 3; col++ ) {
				String stringFicha = listaDeListas.get( row ).get( col );
				if( stringFicha != null ) {
					Ficha ficha = Ficha.valueOf( stringFicha );
					actualizarEstado( row, col, ficha );
				}
			}
		}
	}

	public boolean esVacio() {
		return fichas == 0;
	}

	public void ponerFicha(Ficha x, int i, int j) {
		if (tablero[i][j] != null)
			throw new IllegalArgumentException(
					String.format("Poniendo %s en posicion (%d, %d) "
							+ "que esta ocupada con %s", 
							x, i, j, tablero[i][j]));
		
		actualizarEstado( i, j, x );
	}

	public boolean lleno() {
		return fichas == 9;
	}

	public boolean hayFichaEnLaPosicion(int x, int y) {
		if( tablero[x][y] != null ) return true;
		return false;
	}

	public Ficha ficha(int x, int y) {
		return tablero[x][y];
	}
	
	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) return false;
		if( this == obj ) return true;
		if( this.getClass() != obj.getClass() ) return false;
		Tablero other = (Tablero) obj;
		boolean equals = true;
		for( int row = 0; row < 3 && equals; row++ ) {
			for( int col = 0; col < 3 && equals; col++ ) {
				equals = equals && tablero[row][col] == other.tablero[row][col];
			}
		}
		return equals;
	}
	
	private void actualizarEstado( int row, int col, Ficha ficha ) {
		tablero[row][col] = ficha;
		if( ficha.equals( Ficha.X ) ) {
			nroDeXs++;
		} else {
			nroDeOs++;
		}
		fichas++;
	}

	public int nroDeXs() {
		return nroDeXs;
	}

	public int nroDeOs() {
		return nroDeOs;
	}

}
