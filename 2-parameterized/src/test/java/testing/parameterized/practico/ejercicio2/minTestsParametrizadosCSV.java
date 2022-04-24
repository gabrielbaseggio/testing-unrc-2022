package testing.parameterized.practico.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import testing.parameterized.teoria.MinListFromString;

public class minTestsParametrizadosCSV {
	@ParameterizedTest(name = "{index}: min element in {0} is {1}")
	@CsvSource({ 
		"'[1,2,3]',	1"
	})
	void minListParamTest(@ConvertWith(MinListFromString.class) MinList l, int expected) {
		int result = (int) l.min();
		assertEquals(expected, result);
	}
	
	@ParameterizedTest(name = "{index}: min element in {0} is {1}")
	@CsvSource({ 
		"'[]',	java.lang.IllegalArgumentException",
		"'[null]', java.lang.NullPointerException",
		"null, java.lang.NullPointerException"
	})
	void minListParamTestNeg(@ConvertWith(MinListFromString.class) MinList l, Class expected) {
		assertThrows(expected, () -> l.min());
	}
}