package games.tiktaktoe;

import java.util.List;

public class TikTakToe {
	
	Token[][] board;
	/**
	 * flag that indicates the current player
	 * true for X
	 * false for O
	 */
	boolean currentPlayer;
	Token winner;
	
	public TikTakToe() {
		board = new Token[3][3];
		for( int i = 0; i < 3; i++ ) {
			for( int j = 0; j < 3; j++ ) {
				board[i][j] = Token.IDDLE;
			}
		}
		
		currentPlayer = true;
		winner        = null;
	}

	public TikTakToe(List<Token> tokenList) {
		for( int i = 0; i < 3; i++ ) {
			for( int j = 0; j < 3; j++ ) {
				board[i][j] = tokenList.get( i * 3 + j );
			}
		}
	}

	public int tokens() {
		/*if( board[0][0] != Token.IDDLE && board[1][1] != Token.IDDLE && board[2][2] != Token.IDDLE ) return 3;
		if( board[0][0] != Token.IDDLE && board[1][1] != Token.IDDLE ) return 2;
		if( board[0][0] != Token.IDDLE ) return 1;
		if( board[0][1] != Token.IDDLE ) return 1;
		if( board[1][1] != Token.IDDLE ) return 1;*/
		
		int nTokens = 0;
		for( int i = 0; i < 3; i ++ ) {
			for( int j = 0; j < 3; j++ ) {
				nTokens += ( board[i][j] != Token.IDDLE )? 1 : 0; 
			}
		}
		return nTokens;
	}

	public void put(Integer int1, Integer int2) {
		if( board[int1][int2].equals( Token.IDDLE ) ) {
			board[int1][int2] = currentPlayer();
			currentPlayer = !currentPlayer;
		}
	}

	public Token get(Integer int1, Integer int2) {
		return board[int1][int2];
	}

	public void setStartingPlayer(Token token) {
		currentPlayer = token.equals( Token.X );
	}

	public Token currentPlayer() {
		if( currentPlayer ) {
			return Token.X;
		} else {
			return Token.O;
		}
	}

	public boolean gameIsOver() {
		//diagonal principal
		if( !board[0][0].equals( Token.IDDLE ) && board[0][0].equals( board[1][1] ) && board[1][1].equals( board[2][2] ) ) {
			winner     = board[0][0];
		}
		
		if( !board[0][2].equals( Token.IDDLE ) && board[0][2].equals( board[1][1] ) && board[1][1].equals( board[2][0] ) ) {
			winner     = board[0][2];
		}
		
		//fila 1
		//if( !board[0][0].equals( Token.IDDLE ) && board[0][0].equals( board[0][1] ) && board[0][1].equals( board[0][2] ) ) return true;
		for( int row = 0; row < 3; row++ ) {
			if( !board[row][0].equals( Token.IDDLE ) && board[row][0].equals( board[row][1] ) && board[row][1].equals( board[row][2] ) ) { 
				winner     = board[row][0];
			}
		}
		
		for( int column = 0; column < 3; column++ ) {
			if( !board[0][column].equals( Token.IDDLE ) && board[0][column].equals( board[1][column] ) && board[1][column].equals( board[2][column] ) ) { 
				winner     = board[0][column];
			}
		}
		
		//columna 1
		//if( !board[0][0].equals( Token.IDDLE ) && board[0][0].equals( board[1][0] ) && board[1][0].equals( board[2][0] ) ) return true;
		//columna 2
		//if( !board[0][1].equals( Token.IDDLE ) && board[0][1].equals( board[1][1] ) && board[1][1].equals( board[2][1] ) ) return true;
		//columna 3
		//if( !board[0][2].equals( Token.IDDLE ) && board[0][2].equals( board[1][2] ) && board[1][2].equals( board[2][2] ) ) return true;
		return winner != null || tokens() == 9;
	}

	protected void put(int i, int j, Token token) {
		board[i][j] = token;
	}
	
	public Token whosTheWinner() {
		/**
		 * //diagonal principal
		 * if( !board[0][0].equals( Token.IDDLE ) && board[0][0].equals( board[1][1] ) && board[1][1].equals( board[2][2] ) ) winner = board[0][0];
		 * //fila 1
		 * if( !board[0][0].equals( Token.IDDLE ) && board[0][0].equals( board[0][1] ) && board[0][1].equals( board[0][2] ) ) winner = board[0][0];
		 * //columna 1
		 * if( !board[0][0].equals( Token.IDDLE ) && board[0][0].equals( board[1][0] ) && board[1][0].equals( board[2][0] ) ) winner = board[0][0];
		 * //columna 2
		 * if( !board[0][1].equals( Token.IDDLE ) && board[0][1].equals( board[1][1] ) && board[1][1].equals( board[2][1] ) ) winner = board[0][1];
		 * //columna3
		 * if( !board[0][2].equals( Token.IDDLE ) && board[0][2].equals( board[1][2] ) && board[1][2].equals( board[2][2] ) ) winner = board[0][2];
		 * //antidiagonal
		 * if( !board[0][2].equals( Token.IDDLE ) && board[0][2].equals( board[1][1] ) && board[1][1].equals( board[2][0] ) ) winner = board[0][2];
		 */
		
		gameIsOver();
		return winner;
	}
	
}
