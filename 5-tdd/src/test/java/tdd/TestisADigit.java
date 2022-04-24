package tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TestisADigit {
	@ParameterizedTest
	@CsvSource({
		"0, 0, true",
		"1, 1, true",
		"2, 2, true",
		"1, 15, true",
		"1, 21, true",
		"3, 153, true",
		"1, 3, false",
		"2, 15, false",
		"3, 21, false",
		"4, 153, false"
	})
	void isADigitParamTest( int d, int n, boolean expected ) {
		boolean res = Digits.isADigit(d, n);
		assertThat( res ).isEqualTo( expected );
	}
}
