package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestToDigit {

	@ParameterizedTest
	@CsvSource({
		"0,0",
		"1,1",
		"2,2",
		"3,3",
		"4,4",
		"5,5",
		"6,6",
		"7,7",
		"8,8",
		"9,9"
	})
	public void toDigitParameterizedTest( Character c, int expected ) {
		assertEquals( Digits.toDigit( c ), expected );
	}
}
