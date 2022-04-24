package testing.propertybased.practico.ejercicio3;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assumptions.assumeThat;

import java.util.Set;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Report;
import net.jqwik.api.Reporting;
//import testing.parameterized.practico.ejercicio3.*;

public class MinListPropertyBasedTest {
	
	private int size = 5;
	
	/**
     * input generator method
     * @return test inputs
     */
	@Provide
	Arbitrary<MinList<Integer>> MinListProvider() {
		Arbitrary<Set<Integer>> sets = Arbitraries.integers()
				.between( -5, 5 )
				.set()
				.ofMaxSize( size );
		return sets.map( s -> new MinList<Integer>( s ) );
	}
	
	
	@Property 
    @Report(Reporting.GENERATED)
	void minListPropertyBasedTest(
			@ForAll ("MinListProvider") MinList<Integer> minList) {
		assumeThat( minList ).isNotEmpty();
		
		Integer result = (Integer) minList.min();
		
		assertThat( minList ).filteredOn( i -> result.compareTo( i ) > 0 ).isEmpty();
	}	
}
