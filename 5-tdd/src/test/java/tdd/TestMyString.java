package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestMyString {
	@Test
	public void containsEmptyStringACharacter() {
		assertFalse( MyString.contains( "", 'a' ) );
	}
	
	@ParameterizedTest
	@CsvSource({
		"a, a, true",
		"a, b, false",
		"ab, b, true",
		"ab, c, false",
	})
	public void containsParameterizedTest( String s, Character c, boolean expected ) {
		assertEquals( MyString.contains( s, c ), expected );
	}
	
	@Test
	public void splitOnAnEmptyString() {
		String [] expected = new String[] {""};
		assertTrue( MyString.split("", ",").equals( expected ) );
		//assertThat( MyString.split("", ",") ).isEqualTo( expected );
		//assertEquals( MyString.split( "" , "," ), expected );
	}
}
