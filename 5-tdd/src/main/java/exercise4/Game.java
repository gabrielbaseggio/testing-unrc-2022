package exercise4;

public class Game {
	
	private int score = 0;
	private int[] rolls = new int[21];
	private Frame[] frames = new Frame[10];
	private int movement = 0;
	
	public void roll( int pins ) {
		// TODO
		score    = score + pins;
		rolls[movement] = pins;
		if( pins == 10 && movement % 2 == 0 ) {
			movement += 2;
		} else {
			movement++;
		}
	}
	
	public int score() {
		//return score;
		int s = 0;
		for( int i = 0; i < rolls.length; i++ ) {
			s += rolls[i];
		}
		
		//System.out.println(s);
		
		int bonus = 0;
		for( int i = 2; i < rolls.length; i+=2 ) {
			if( rolls[i - 2] + rolls[i - 1] == 10 ) {
				bonus = bonus + rolls[i];
			}
		}
		
		//System.out.println(bonus);
		
		//for( int i = 0; i < rolls.length; i++ ) {
			//if( rolls[i] == 10 ) {
				//System.out.println(i + 2 + " - " + rolls[i + 2]);
				//System.out.println(i + 3 + " - " + rolls[i + 3]);
				//bonus = bonus + rolls[i + 2] + rolls[i + 3];
			//}
		//}
		
		//System.out.println(bonus);
		return s + bonus;
		// TODO
	}
}
