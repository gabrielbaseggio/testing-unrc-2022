package testing.graph.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrintPrimesTest {
	
	private PrintPrimes primes;
	
	@BeforeEach
	public void setUp() {
		primes = new PrintPrimes();
	}
	
	//@Test
	public void PrintPrimesTest1() {
		assertEquals(primes.getPrimes(3), Arrays.asList(new int[] {2, 3, 5}));
	}
	
	@Test
	public void PrintPrimesTest2() {
		assertEquals(primes.getPrimes(5), Arrays.asList(new int[] {2, 3, 5, 7, 11}));
	}
	
	@Test
	public void PrintPrimesTest3() {
		assertEquals(primes.getPrimes(1), Arrays.asList(new int[] {2}));
	}
}
