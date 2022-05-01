package tdd;

public class MyMath {
	
	public static int pow( int b, int e ) {
		if( e == 0 || b == 1 ) return 1;
		
		int result = b;
		while( e != 1 ) {
			result = result * b;
			e--;
		}
		
		return result;
	}

}
