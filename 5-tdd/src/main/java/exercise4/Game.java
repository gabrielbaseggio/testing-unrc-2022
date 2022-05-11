package exercise4;

public class Game {
	
	private Frame[] frames   = new Frame[10];
	private int currentFrame = 0;
	
	public Game() {
		int currentFrame;
		for( currentFrame = 0; currentFrame < frames.length - 1; currentFrame++ ) {
			frames[currentFrame] = new Frame();
		}
		
		frames[currentFrame] = new TenthFrame();
		
		for( currentFrame = 0; currentFrame < frames.length - 1; currentFrame++ ) {
			frames[currentFrame].setSuccesor( frames[currentFrame + 1] );
		}
	}
	
	public void roll( int pins ) {
		frames[currentFrame ].knockDown(pins);
		if( frames[currentFrame].complete() ) {
			currentFrame++;
		}
	}
	
	public int score() {
		int score = 0;
		for( Frame frame : frames ) {
			score += frame.score();
		}
		
		return score;
	}
}
