package games.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class GameIsOverTDD {
	
	@ParameterizedTest
	@CsvSource({
		"'[X,O,O, ,X, , , ,X]', true",
		"'[X,X,X,O,O, , , , ]', true",
		"'[X,O,_,X,O,_,X,_,_]', true",
		"'[O,X,_,O,X,_,_,X,_]', true",
		"'[_,O,X,_,O,X,_,_,X]', true",
		"'[_,_,X,_,X,O,X,O,_]', true",
		"'[X,O,X,O,X,O,O,X,O]', true",
		"'[_,_,_,_,_,_,_,_,_]', false"
	})
	public void gameIsOver( @ConvertWith(TikTakToeFromString.class) TikTakToe tiktaktoe, boolean expected ) {
		assertEquals( tiktaktoe.gameIsOver(), expected );
	}

}
