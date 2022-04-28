package games.tiktaktoe;

public class TikTakToe {
	
	Token[][] board;
	
	public TikTakToe() {
		board = new Token[3][3];
		for( int i = 0; i < 3; i++ ) {
			for( int j = 0; j < 3; j++ ) {
				board[i][j] = Token.IDDLE;
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

	public void put(Integer int1, Integer int2, Token t) {
		board[int1][int2] = t;
	}

	public Token get(Integer int1, Integer int2) {
		return board[int1][int2];
	}

	

}
