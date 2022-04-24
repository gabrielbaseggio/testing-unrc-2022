package tdd;

public class Digits {
	public static boolean isADigit( int d, int n ) {
		
		do {
			if( (n % 10) == d ) return true;
			n /= 10;
		} while( n != 0 );
		
		return false;
	}
}
