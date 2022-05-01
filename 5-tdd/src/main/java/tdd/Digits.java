package tdd;

public class Digits {
	public static boolean isADigit( int d, int n ) {
		
		do {
			if( (n % 10) == d ) return true;
			n /= 10;
		} while( n != 0 );
		
		return false;
	}

	public static int toDigits(String numbers) {
		
		if( numbers.length() > 0 ) {
			int i = 0;
			int result = 0;
			while( numbers.length() - i != 0 ) {
				result = result + toDigit( numbers.charAt( i ) ) * MyMath.pow( 10, numbers.length() - (i + 1) ) ;
				i++;
			}
			
			return result;
		}
		
		return 0;
	}
	
	public static int toDigit( Character c ) {
		if( c.equals('1') ) return 1;
		if( c.equals('2') ) return 2;
		if( c.equals('3') ) return 3;
		if( c.equals('4') ) return 4;
		if( c.equals('5') ) return 5;
		if( c.equals('6') ) return 6;
		if( c.equals('7') ) return 7;
		if( c.equals('8') ) return 8;
		if( c.equals('9') ) return 9;
		return 0;
		//int asciiValueOfZero = 48;
		//int asciiValue = c;
		//return asciiValue - asciiValueOfZero;
	}
}
