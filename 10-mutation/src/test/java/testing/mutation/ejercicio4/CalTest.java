package testing.mutation.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalTest {
	@ParameterizedTest
	@CsvSource({
		"1, 1, 1, 2, 2000, 31",
		"1, 1, 31, 1, 2000, 30",
		"1, 1, 31, 3, 2000, 90",
		"1, 1, 31, 3, 2100, 89"
	})
	public void killingCalMutants(int day1, int month1, int day2, int month2, int year, int expected) {
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertEquals(result, expected);
	}
}
