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
	
	public TikTakToe() {
		board = new Token[3][3];
		for( int i = 0; i < 3; i++ ) {
			for( int j = 0; j < 3; j++ ) {
				board[i][j] = Token.IDDLE;
			}
		}
		
		currentPlayer = true;
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

	

}
