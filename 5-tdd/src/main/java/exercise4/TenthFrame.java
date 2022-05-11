package exercise4;

public class TenthFrame extends Frame {

	private int[] moves = new int[3];

	@Override
	public boolean complete() {
		if( move() <= 2 ) return false;
		return true;
	}
	
	@Override
	public void knockDown(int pins) {
		if( !complete() ) {
			moves[move()] = pins;
			baseScore(pins);
			increaseMoves();
		}
	}

	@Override
	public int score() {
		return baseScore;
	}
	
	protected int getMove(int m) {
		return moves[m];
	}

}
