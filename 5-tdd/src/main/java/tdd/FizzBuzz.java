package tdd;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
	
	private Output output;
	
	public void setOutput( Output output ) {
		this.output = output;
	}

	public String fizzbuzz(int i) {
		String res = new String();
		boolean cond1 = i % 3 == 0 || Digits.isADigit(3, i);
		boolean cond2 = i % 5 == 0 || Digits.isADigit(5, i);
		if ( cond1 )
			res += "Fizz";
		if ( cond2 )
			res += "Buzz";
		
		return (!(cond1 || cond2)? Integer.toString( i ) : res );
	}
	
	public List<String> listFizzBuzz( int i, int j ) {
		List<String> res = new LinkedList<>();
		for( int k = i; k <= j; k++ ) {
			res.add( fizzbuzz( k ) );
		}
		
		return res;
	}
	
	public void printListFizzBuzz( int i, int j ) {
		List<String> res = listFizzBuzz( i, j );
		for( String e : res ) {
			output.print( e );
		}
	}

}
