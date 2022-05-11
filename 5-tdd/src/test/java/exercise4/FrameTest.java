package exercise4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FrameTest {
	@Test
	void createFrame() {
		Frame frame = new Frame();
		assertEquals( frame.score(), 0 );
	}
	
	@Test
	void TwoPinsInFrame() {
		Frame frame = new Frame();
		frame.knockDown(2);
		assertEquals( frame.score(), 2 );
	}
	
	@Test
	void ItWasASpare1() {
		Frame frame = new Frame();
		frame.knockDown(2);
		frame.knockDown(8);
		assertTrue( frame.spare() );
	}
	
	@Test
	void ItWasASpare2() {
		Frame frame = new Frame();
		frame.knockDown(10);
		assertFalse( frame.spare() );
	}
	
	@Test
	void SpareInFrame1() {
		Frame frame1 = new Frame();
		Frame frame2 = new Frame();
		frame1.setSuccesor( frame2 );
		frame1.knockDown(5);
		frame1.knockDown(5);
		frame2.knockDown(2);
		assertEquals( frame1.score(), 12 );
	}
	
	@Test
	void ItWasAStrike() {
		Frame frame = new Frame();
		frame.knockDown(10);
		assertTrue( frame.strike() );
	}
	
	@Test
	void StrikeInFrame1() {
		Frame frame1 = new Frame();
		Frame frame2 = new Frame();
		frame1.setSuccesor(frame2);
		frame1.knockDown(10);
		frame2.knockDown(5);
		frame2.knockDown(5);
		assertEquals( frame1.score(), 20 );
	}
	
	@Test
	void frameComplete1() {
		Frame frame1 = new Frame();
		frame1.knockDown(5);
		frame1.knockDown(5);
		assertTrue( frame1.complete() );
	}
	
	@Test
	void frameComplete2() {
		Frame frame1 = new Frame();
		frame1.knockDown(0);
		frame1.knockDown(0);
		assertTrue( frame1.complete() );
	}
	
	@Test
	void tenthFrameComplete1() {
		Frame tenthFrame = new TenthFrame();
		assertFalse( tenthFrame.complete() );
	}
	
	@Test
	void tenthFrameComplete2() {
		Frame tenthFrame = new TenthFrame();
		tenthFrame.knockDown(5);
		tenthFrame.knockDown(5);
		assertFalse( tenthFrame.complete() );
	}
	
	@Test
	void tenthFrameComplete3() {
		Frame tenthFrame = new TenthFrame();
		tenthFrame.knockDown(5);
		tenthFrame.knockDown(5);
		tenthFrame.knockDown(5);
		assertTrue( tenthFrame.complete() );
	}
	
	@Test
	void tenthFrameComplete4() {
		Frame tenthFrame = new TenthFrame();
		tenthFrame.knockDown(10);
		assertFalse( tenthFrame.complete() );
	}
	
	@Test
	void tenthFrameComplete5() {
		Frame tenthFrame = new TenthFrame();
		tenthFrame.knockDown(10);
		tenthFrame.knockDown(5);
		tenthFrame.knockDown(5);
		assertTrue( tenthFrame.complete() );
	}
	
	@Test
	void SpareInFrame2() {
		Frame frame = new TenthFrame();
		frame.knockDown(5);
		frame.knockDown(5);
		frame.knockDown(5);
		assertEquals( frame.score(), 15 );
	}
	
	@Test
	void SpareInFrame3() {
		Frame frame = new TenthFrame();
		frame.knockDown(5);
		frame.knockDown(5);
		frame.knockDown(8);
		assertEquals( frame.score(), 18 );
	}
	
	@Test
	void cannotKnockDownThreeTimes() {
		Frame frame = new Frame();
		frame.knockDown(1);
		frame.knockDown(1);
		frame.knockDown(1);
		assertEquals( frame.score(), 2 );
	}
	
	@Test
	void firstMove() {
		Frame frame = new Frame();
		frame.knockDown(1);
		assertEquals( frame.fstMove(), 1 );
	}
	
	@Test
	void sndMove1() {
		Frame frame = new Frame();
		frame.knockDown(1);
		frame.knockDown(2);
		assertEquals( frame.fstMove(), 1 );
		assertEquals( frame.sndMove(), 2 );
	}
	
	@Test
	void sndMove3() {
		TenthFrame frame = new TenthFrame();
		frame.knockDown(1);
		frame.knockDown(2);
		frame.knockDown(3);
		assertEquals( frame.getMove(0), 1 );
		assertEquals( frame.getMove(1), 2 );
		assertEquals( frame.getMove(2), 3 );
	}
}
