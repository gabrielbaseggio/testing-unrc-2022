package games.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PutTDD {
	@ParameterizedTest
	@CsvSource({
		"0, 0",
		"0, 1",
		"0, 2"
	})
	public void putParameterizedTest( int x, int y, Token token ) {
		TikTakToe tiktaktoe = new TikTakToe();
		tiktaktoe.put(x, y);
		tiktaktoe.put(x, y);
		assertEquals( tiktaktoe.get(x, y), Token.X );
	}
}