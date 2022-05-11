package exercise4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
	
	private Game game;
	
	@BeforeEach
	void setUp() {
		game = new Game();
	}
	
	@Test
	void createGame() {
		assertEquals( game.score(), 0 );
	}
	
	@Test
	void worstGame() {
		rollNTimes( 20, 0 );
		assertEquals( game.score(), 0 );
	}
	
	@Test
	void TwoPins() {
		game.roll(2);
		rollNTimes( 19, 0 );
		assertEquals( game.score(), 2 );
	}
	
	@Test
	void Spare1() {
		game.roll(3);
		game.roll(7); // score for frame 1 = 10 + 2 = 12 
		game.roll(2); // score for frame 2 = 2
		rollNTimes( 17, 0 );
		assertEquals( game.score(), 14 );
	}
	
	@Test
	void Spare2() {
		game.roll(3);
		game.roll(7); // spare - score for frame 1 = 10 + 3 = 13 
		game.roll(3); 
		game.roll(1); // score for frame 2 = 4
		rollNTimes( 16, 0 );
		assertEquals( game.score(), 17 );
	}
	
	@Test
	void Strike1() {
		game.roll(10); // strike - score from frame 1 = 10 + 3 + 5 = 18 
		
		game.roll(3);
		game.roll(5); // score from frame 2 = 3 + 5 = 8
		rollNTimes( 16, 0 );
		assertEquals( game.score(), 26 );
	}
	
	@Test
	void SpareInTheTenthFrame() {
		rollNTimes( 18, 0 );
		game.roll(5);
		game.roll(5); // spare in tenth-frame, score in frame 10 = 10 + 8
		game.roll(8); // roll extra ball
		assertEquals( game.score(), 18 );
	}
	
	private void rollNTimes( int n, int p ) {
		for( int i = 0; i < n; i++ ) {
			game.roll(p);
		}
	}
	
}
