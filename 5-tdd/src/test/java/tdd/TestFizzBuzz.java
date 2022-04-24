package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

public class TestFizzBuzz {
	
	private FizzBuzz fizzbuzz;
	
	@BeforeEach
	public void setup() {
		fizzbuzz = new FizzBuzz();
	}

	@ParameterizedTest
	@CsvSource({
		"15, FizzBuzz",
		"30, FizzBuzz",
		"51, FizzBuzz",
		"4, 4",
		"2, 2",
		"6, Fizz",
		"3, Fizz",
		"13, Fizz",
		"23, Fizz",
		"5, Buzz",
		"10, Buzz",
		"151, Buzz"
	})
	public void fizzBuzzParamTest(int n, String expected) {
		String res = fizzbuzz.fizzbuzz( n );
		assertThat(res).isEqualTo(expected);
	}
	
	@Test
	public void printListFizzBuzzOneToFive() {
		Output o = createStrictMock( Output.class );
		o.print( "1" );
		o.print( "2" );
		o.print( "Fizz" );
		o.print( "4" );
		o.print( "Buzz" );
		replay( o );
		fizzbuzz.setOutput( o );
		fizzbuzz.printListFizzBuzz( 1, 5 );
		verify( o );
	}
}
