package exercise4;

public class Frame {
	
	private Frame succesor;
	protected int baseScore = 0;
	private int[] moves = new int[2];
	private int move = 0;

	public int score() {
		// TODO Auto-generated method stub
		if( strike() ) {
			return baseScore + succesor.fstMove() + succesor.sndMove();
		}
		return (spare())? baseScore + succesor.fstMove() : baseScore;
	}

	public void knockDown(int pins) {
		// TODO Auto-generated method stub
		if( !complete() ) {
			moves[move] = pins;
			baseScore += pins;
			move++;
		}
	}

	protected boolean spare() {
		// TODO Auto-generated method stub
		return !strike() && fstMove() + sndMove() == 10;
	}
	
	protected boolean strike() {
		// TODO Auto-generated method stub
		return fstMove() == 10;
	}
	
	protected int move() {
		return move;
	}

	public void setSuccesor(Frame succesor) {
		// TODO Auto-generated method stub
		this.succesor = succesor;
	}

	public boolean complete() {
		if( baseScore == 10 || move == 2 ) return true;
		return false;
	}

	protected int fstMove() {
		// TODO Auto-generated method stub
		return moves[0];
	}

	public int sndMove() {
		// TODO Auto-generated method stub
		return moves[1];
	}
	
	protected void fstMove(int pins) {
		moves[0] = pins;
	}
	
	protected void sndMove(int pins) {
		moves[1] = pins;
	}
	
	protected void increaseMoves() {
		move++;
	}
	
	protected void baseScore(int pins) {
		baseScore += pins;
	}
	
}
