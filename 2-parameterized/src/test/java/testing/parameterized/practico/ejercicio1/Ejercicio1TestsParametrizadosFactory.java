package testing.parameterized.practico.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import testing.parameterized.teoria.EjemplosArray;

public class Ejercicio1TestsParametrizadosFactory {
	@ParameterizedTest(name = "{index}: last 0 in {0} is in position {1}")
	@MethodSource("lastZeroArgsProvider")
	void lastZeroParamTest(int [] arr, int expected) {
		int result = Ejercicio1.lastZero(arr);
		assertEquals(expected, result);
	}
	
	static Stream<Arguments> lastZeroArgsProvider() {
	    return Stream.of(
	    		Arguments.of(new int[] {0}, 0),
	    		Arguments.of(new int[] {0, 0}, 1)
	    );
	}
	
	@ParameterizedTest(name = "{index}: number of 0s in {0} is {1}")
	@MethodSource("numZeroArgsProvider")
	void numZeroParamTest(int [] arr, int expected) {
		int result = Ejercicio1.numZero(arr);
		assertEquals(expected, result);
	}
	
	static Stream<Arguments> numZeroArgsProvider() {
	    return Stream.of(
	    		Arguments.of(new int[] {1, 0, 1}, 1),
	    		Arguments.of(new int[] {0}, 1)
	    );
	}
}