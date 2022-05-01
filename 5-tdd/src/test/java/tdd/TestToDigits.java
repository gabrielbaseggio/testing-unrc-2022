package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestToDigits {
	
	@ParameterizedTest
	@CsvSource({
		"0, 0",
		"1, 1",
		"2, 2",
		"10, 10",
		"11, 11",
		"100, 100",
		"101, 101",
		"1000, 1000"
	})
	public void toDigitsParameterizedTest( String s, int expected ) {
		assertEquals( Digits.toDigits( s ), expected );
	}
}
