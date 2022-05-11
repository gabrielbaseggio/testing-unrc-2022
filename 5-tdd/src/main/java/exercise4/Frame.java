package exercise4;

public class Frame {
	
	private Frame succesor;
	private int[] moves = new int[2];
	protected int baseScore = 0;
	private int move        = 0;

	public int score() {
		return baseScore + bonus();
	}

	private int bonus() {
		int bonus = 0;
		if( strike() ) {
			if( succesor.strike() ) {
				bonus = succesor.moves[0] + succesor.succesor.moves[0];
			} else {
				bonus = succesor.moves[0] + succesor.moves[1];
			}
		}
		
		if( spare() ) { bonus = succesor.moves[0]; }
		return bonus;
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
		return !strike() && moves[0] + moves[1] == 10;
	}
	
	protected boolean strike() {
		// TODO Auto-generated method stub
		return moves[0] == 10;
	}

	public void setSuccesor(Frame succesor) {
		// TODO Auto-generated method stub
		this.succesor = succesor;
	}

	public boolean complete() {
		if( strike() || move == 2 ) return true;
		return false;
	}
	
}
