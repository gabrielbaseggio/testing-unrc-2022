package testing.propertybased.practico.ejercicio2;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ListsTest {

	private static Stream<Arguments> ArrayListProvider() {
		return Stream.of(
				Arguments.of( new ArrayList<>( Arrays.asList( 1,2,3 ) ), 2 ),
				Arguments.of( new ArrayList<>( Arrays.asList( 1 ) ), 2 ),
				Arguments.of( new ArrayList<>( Arrays.asList( 2 ) ), 2 ),
				Arguments.of( new ArrayList<>( Arrays.asList( 1,3 ) ), 2 )
				);
	}
	
	@ParameterizedTest
	@MethodSource("ArrayListProvider")
	void addRemoveCancelEachOther( ArrayList<Integer> list, Integer element ) {
		ArrayList<Integer> orig = new ArrayList<Integer>(list);
		assumeThat( list ).doesNotContain( element );
		list.add( element );
		list.remove( element );
		assertThat( list ).isEqualTo( orig );
	}
	
	@ParameterizedTest
	@MethodSource("ArrayListProvider")
	void addIncreaseLength( ArrayList<Integer> list, Integer element ) {
		int origSize = list.size();
		assumeThat( list ).doesNotContain( element );
		list.add( element );
		assertThat( list ).hasSize( origSize + 1 );
	}
	
	//Tendria que escribir otra propiedad de listas valida?
	//O tendria que escribir una propiedad de listas tal que add no incrementa la longitud?
	@ParameterizedTest
	@MethodSource("ArrayListProvider")
	void addDoesNotIncreaseLength( ArrayList<Integer> list, Integer element ) {
		int origSize = list.size();
		assumeThat( list ).contains( element );
		list.add( element );
		assertThat( list ).hasSize( origSize );
	}
}
