package testing.mutation.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PatternIndexTest {
	@Test
	public void killPatternIndexA() {
		String subject = "hola";
		int resultOrig = PatternIndex.patternIndex(subject, subject);
		int resultMut  = PatternIndexA.patternIndex(subject, subject);
		assertTrue( resultOrig != resultMut );
	}
	
	@Test
	public void killPatternIndexB() {
		String subject = "hhola";
		String pattern = "hola";
		int resultOrig = PatternIndex.patternIndex(subject, pattern);
		int resultMut  = PatternIndexB.patternIndex(subject, pattern);
		assertTrue( resultOrig != resultMut );
	}
}
