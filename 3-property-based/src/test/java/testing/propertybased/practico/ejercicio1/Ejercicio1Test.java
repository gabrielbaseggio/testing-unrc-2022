package testing.propertybased.practico.ejercicio1;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assumptions.assumeThat;

import java.util.Arrays;
import java.util.stream.IntStream;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Report;
import net.jqwik.api.Reporting;

public class Ejercicio1Test {
	
	@Provide
	Arbitrary<int []> findLastArrayProvider() {
		return Arbitraries.integers().between(0, 10).array(int[].class).ofMaxSize(10);
	}
	
	@Provide
	Arbitrary<Integer> elementProvider() {
		return Arbitraries.integers().between(0, 10);
	}
	
	@Property
	@Report(Reporting.GENERATED)
	void findLastProperty( 
			@ForAll("findLastArrayProvider") int[] arr,
			@ForAll("elementProvider") int elem) {
		assumeThat( arr ).contains( elem );
		int result = Ejercicio1.findLast( arr, elem );
		assertThat( arr[ result ] ).isEqualTo(elem);
		IntStream fromResult = Arrays.stream( arr ).skip( result );
		assertThat( fromResult ).containsOnlyOnce( elem );
	}
	
	@Provide
	Arbitrary<int []> lastZeroArrayProvider() {
		return Arbitraries.integers().between(0, 1).array(int[].class).ofMaxSize(10);
	}
	
	@Property
	@Report(Reporting.GENERATED)
	void lastZeroProperty1( 
			@ForAll("lastZeroArrayProvider") int[] arr) {
		assumeThat( arr ).doesNotContain( 0 );
		assertEquals( Ejercicio1.lastZero( arr ), -1 );
	}
	
	@Property
	@Report(Reporting.GENERATED)
	void lastZeroProperty2( 
			@ForAll("lastZeroArrayProvider") int[] arr) {
		assumeThat( arr ).contains( 0 );
		int result = Ejercicio1.lastZero( arr );
		assertThat( arr[ result ] ).isEqualTo( 0 );
		IntStream fromResult = Arrays.stream( arr ).skip( result + 1 );
		assertThat( fromResult ).doesNotContain( 0 );
	}
	
	@Provide
	Arbitrary<int []> numZeroArrayProvider() {
		return Arbitraries.integers().between(0, 1).array(int[].class).ofMaxSize(10);
	}
	
	@Property
	@Report(Reporting.GENERATED)
	void numZeroProperty1( 
			@ForAll("numZeroArrayProvider") int[] arr) {
		assumeThat( arr ).doesNotContain( 0 );
		int result = Ejercicio1.numZero(arr);
		assertEquals(result, 0);
	}
	
	@Property
	@Report(Reporting.GENERATED)
	void numZeroProperty2( 
			@ForAll("numZeroArrayProvider") int[] arr) {
		assumeThat( arr ).contains( 0 );
		int result = Ejercicio1.numZero(arr);
		assertEquals( Arrays.stream( arr ).filter( i -> i == 0 ).count(), result );
	}
	
	
	@Property
	@Report(Reporting.GENERATED)
	void numZeroProperty3( 
			@ForAll("numZeroArrayProvider") int[] arr) {
		//assumeThat( arr ).contains( 0 );
		int result = Ejercicio1.numZero( arr );
		//assertEquals(Arrays.stream( arr ).filter( i -> i == 0 ).count(), result );
		assertThat(Arrays.stream( arr )).filteredOn( i -> i == 0 ).hasSize(result);

	
	}
	
	@Provide
	Arbitrary<int []> oddOrPosArrayProvider() {
		return Arbitraries.integers().between(-10, 10).array(int[].class).ofMaxSize(10);
	}
	
	@Property
	@Report(Reporting.GENERATED)
	void oddOrPosProperty( 
			@ForAll("oddOrPosArrayProvider") int[] arr) {
		int result = Ejercicio1.oddOrPos( arr );
		assertThat(Arrays.stream( arr )).filteredOn( i -> Math.abs( i % 2 ) == 1 || i > 0 ).hasSize( result );
	}
	
	
	@Provide
	Arbitrary<int []> countPositiveArrayProvider() {
		return Arbitraries.integers().between(-10, 10).array(int[].class).ofMaxSize(10);
	}
	
	@Property
	@Report(Reporting.GENERATED)
	void countPositiveProperty( 
			@ForAll("countPositiveArrayProvider") int[] arr) {
		int result = Ejercicio1.countPositive( arr );
		assertThat( Arrays.stream( arr ) ).filteredOn( i -> i > 0 ).hasSize( result );
	}
	
}
