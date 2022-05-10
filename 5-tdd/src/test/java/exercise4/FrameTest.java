package exercise4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FrameTest {
	@Test
	void createFrame() {
		Frame frame = new Frame();
		assertEquals( frame.score(), 0 );
	}
}
