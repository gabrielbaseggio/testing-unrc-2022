package testing.graph.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PatternIndexTest {
	
	private static PrintStream fileOut;
	
	@BeforeAll
	public static void setUp() throws FileNotFoundException {
		fileOut = new PrintStream("./out.txt");
		System.setOut(fileOut);
	}
	
	@ParameterizedTest
	@CsvSource ({
		"a, bc, -1",
		"ab, a, 0",
		"ab, ab, 0",
		"ab, ac, -1",
		"ab, b, 1",
		"ab, c, -1",
		"abc, abc, 0",
		"abc, abd, -1",
		"abc, ac, -1",
		"abc, ba, -1",
		"abc, bc, 1"
	})
	public void patternIndexTest1(String subject, String pattern, int expected ) throws FileNotFoundException {
		assertEquals(PatternIndex.patternIndex(subject, pattern), expected);
	}
}
