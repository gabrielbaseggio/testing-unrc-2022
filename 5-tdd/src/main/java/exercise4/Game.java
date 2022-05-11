package exercise4;

public class Game {
	
	private Frame[] frames = new Frame[10];
	//private int movement     = 0;
	//private int score        = 0;
	private int currentFrame = 0;
	
	public Game() {
		//System.out.println( frames );
		for( int currentFrame = 0; currentFrame < frames.length; currentFrame++ ) {
			frames[currentFrame] = new Frame();
		}
		
		for( int currentFrame = 0; currentFrame < frames.length - 1; currentFrame++ ) {
			frames[currentFrame].setSuccesor( frames[currentFrame + 1] );
		}
	}
	
	public void roll( int pins ) {
		// TODO
		//score    = score + pins;
		//rolls[movement] = pins;
		//if( pins == 10 && movement % 2 == 0 ) {
			//movement += 2;
		//} else {
			//movement++;
		//}
		
		frames[currentFrame ].knockDown(pins);
		if( frames[currentFrame].complete() ) {
			currentFrame++;
		}
	}
	
	public int score() {
		int score = 0;
		for( Frame frame : frames ) {
			//System.out.println(frame.score());
			score += frame.score();
		}
		
		return score;
	}
}
