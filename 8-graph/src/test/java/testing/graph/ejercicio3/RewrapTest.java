package testing.graph.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RewrapTest {
	@Test
	public void rewrapTest1() {
		assertEquals(Rewrap.fmtRewrap(new String(), 0), "\n");
	}
}
