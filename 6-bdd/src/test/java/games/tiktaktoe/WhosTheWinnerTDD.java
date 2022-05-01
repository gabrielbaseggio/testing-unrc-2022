package games.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class WhosTheWinnerTDD {
	
	@ParameterizedTest
	@CsvSource({
		"'[X,O,O, ,X, , , ,X]', X",
		"'[X,X,X,O,O, , , , ]', X",
		"'[X,O,_,X,O,_,X,_,_]', X",
		"'[O,X,_,O,X,_,_,X,_]', X",
		"'[_,X,O,_,X,O,_,_,O]', O",
		"'[_,_,O,_,O,X,O,X,_]', O",
	})
	public void gameIsOver( @ConvertWith(TikTakToeFromString.class) TikTakToe tiktaktoe, Token expected ) {
		assertEquals( tiktaktoe.whosTheWinner(), expected );
	}

}
