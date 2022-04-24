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
		/*if( numbers.equals("1") ) return 1;
		if( numbers.equals("2") ) return 2;
		if( numbers.equals("10") ) return 10;
		if( numbers.equals("11") ) return 11;
		if( numbers.equals("100") ) return 100;
		if( numbers.equals("101") ) return 101;*/
		
		if( numbers.length() == 1 ) {
			return toDigit( numbers.charAt(0) );
		}
		
		if( numbers.length() == 2 ) {
			return toDigit( numbers.charAt(0) ) * 10 + toDigit( numbers.charAt(1) );
		}
		
		if( numbers.length() == 3 ) {
			return toDigit( numbers.charAt(0) ) * 10 * 10 + toDigit( numbers.charAt(1) ) * 10 + toDigit( numbers.charAt(2) );
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
