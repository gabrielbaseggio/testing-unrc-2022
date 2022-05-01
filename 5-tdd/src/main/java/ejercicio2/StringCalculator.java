package ejercicio2;

import tdd.Digits;
import tdd.MyString;

public class StringCalculator {
    public static int Add( String numbers ) {
    	
    	//if( !numbers.contains( "," ) ) return Digits.toDigits( numbers );
    	if( MyString.contains( numbers, ',' ) ) return Digits.toDigits( numbers );
    	/*if( numbers.equals( "1,2,3" ) ) return 6;
    	if( numbers.equals( "4,5,6" ) ) return 15;
    	String n1 = numbers.substring(0, numbers.indexOf(','));
    	String n2 = numbers.substring(numbers.indexOf(',') + 1, numbers.length());
    	
    	return Digits.toDigits( n1 ) + Digits.toDigits( n2 );*/
    	
    	String[] numbersArray = MyString.split( numbers, "," );
    	int result = 0;
    	for( String s : numbersArray ) {
    		result += Digits.toDigits( s );
    	}
    	
    	return result;
    }
}
