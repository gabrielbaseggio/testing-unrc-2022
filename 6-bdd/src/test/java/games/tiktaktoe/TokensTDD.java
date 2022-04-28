package games.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TokensTDD {
	@Test
	public void tokensTest1() {
		TikTakToe tiktaktoe = new TikTakToe();
		tiktaktoe.put( 0, 0, Token.X );
		assertEquals( tiktaktoe.tokens(), 1 );
	}
	
	@Test
	public void tokensTest2() {
		TikTakToe tiktaktoe = new TikTakToe();
		tiktaktoe.put( 0, 1, Token.X );
		assertEquals( tiktaktoe.tokens(), 1 );
	}
	
	@Test
	public void tokensTest3() {
		TikTakToe tiktaktoe = new TikTakToe();
		tiktaktoe.put( 1, 1, Token.X );
		assertEquals( tiktaktoe.tokens(), 1 );
	}
	
	@Test
	public void tokensTest4() {
		TikTakToe tiktaktoe = new TikTakToe();
		tiktaktoe.put( 0, 0, Token.X );
		tiktaktoe.put( 1, 1, Token.X );
		assertEquals( tiktaktoe.tokens(), 2 );
	}
	
	@Test
	public void tokensTest5() {
		TikTakToe tiktaktoe = new TikTakToe();
		tiktaktoe.put( 0, 0, Token.X );
		tiktaktoe.put( 1, 1, Token.X );
		tiktaktoe.put( 2, 2, Token.O );
		assertEquals( tiktaktoe.tokens(), 3 );
	}
}
