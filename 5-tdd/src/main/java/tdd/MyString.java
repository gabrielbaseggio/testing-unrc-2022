package tdd;

public class MyString {

	public static boolean contains( String s, Character c ) {
		if( s.isEmpty() ) return false;
		int i = 0;
		while( i < s.length() ) {
			if( c.equals( s.charAt( i ) ) ) return true;
			i++;
		}
		return false;
	}
	
	public static String[] split( String s, String separator ) {
		return new String[] {""};
	}
}
