package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestMyMath {

	@ParameterizedTest
	@CsvSource({
		"0,0,1",
		"1,0,1",
		"2,0,1",
		"1,1,1",
		"2,1,2",
		"2,2,4",
		"3,2,9",
		"4,2,16",
		"10,2,100",
		"100,2,10000",
		"10,3,1000"
	})
	public void myMathPow( int b, int e, int expected ) {
		assertEquals( MyMath.pow(b, e), expected );
	}
}
