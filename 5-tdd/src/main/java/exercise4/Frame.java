package exercise4;

public class Frame {
	
	private Frame succesor;
	private int baseScore = 0;
	private int fstMove;
	private int sndMove;
	private int move = 0;

	public int score() {
		// TODO Auto-generated method stub
		if( strike() ) {
			return baseScore + succesor.fstMove + succesor.sndMove;
		}
		return (spare())? baseScore + succesor.fstMove : baseScore;
	}

	public void knockDown(int pins) {
		// TODO Auto-generated method stub
		if( move == 0 ) {
			fstMove = pins;
		} else {
			sndMove = pins;
		}
		baseScore += pins;
		move++;
	}

	protected boolean spare() {
		// TODO Auto-generated method stub
		return fstMove + sndMove == 10;
	}
	
	protected boolean strike() {
		// TODO Auto-generated method stub
		return fstMove == 10;
	}

	public void setSuccesor(Frame succesor) {
		// TODO Auto-generated method stub
		this.succesor = succesor;
	}

	public boolean complete() {
		if( baseScore == 10 || move == 2 ) return true;
		return false;
	}
	
}
