package testing.parameterized.practico.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import testing.parameterized.teoria.ArrayFromString;

public class Ejercicio1TestsParametrizadosCSV {
	@ParameterizedTest(name = "{index}: last 0 in {0} is in position {1}")
	@CsvSource({ 
		"'[1,2,3]',	-1"
	})
	void lastZeroParamTest(@ConvertWith(ArrayFromString.class) int [] arr, int expected) {
		int result = Ejercicio1.lastZero(arr);
		assertEquals(expected, result);
	}
	
	@ParameterizedTest(name = "{index}: number of 0s in {0} is {1}")
	@CsvSource({
		"'[1,2,3]', 0"
	})
	void numZeroParamTest(@ConvertWith(ArrayFromString.class) int [] arr, int expected) {
		int result = Ejercicio1.numZero(arr);
		assertEquals(expected, result);
	}
}