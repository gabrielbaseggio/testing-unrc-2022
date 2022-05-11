package testing.partition.practico.ejercicio5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class BoundedQueueTest {
	@Test
	public void positiveCapacity() {
		BoundedQueue queue = new BoundedQueue( 1 );
		assertTrue( queue.capacity() > 0 );
	}
	
	@Test
	public void capacityZero() {
		BoundedQueue queue = new BoundedQueue( 0 );
		assertTrue( queue.capacity() == 0 );
	}
	
	@Test
	public void negativeCapacity() {
		assertThrows( IllegalArgumentException.class, () -> new BoundedQueue( -1 ) );
	}
	
	@Test
	public void enqueue1() {
		BoundedQueue queue = new BoundedQueue( 3 );
		queue.enQueue( 1 );
		queue.enQueue( 0 );
		assertEquals( queue.get(0), 1 );
		assertEquals( queue.get(1), 0 );
	}
	
	@Test
	public void enqueue2() {
		BoundedQueue queue = new BoundedQueue( 3 );
		queue.enQueue( 1 );
		assertThrows( NullPointerException.class, () -> queue.enQueue( null ) );
	}
	
	@Test
	public void enqueue3() {
		BoundedQueue queue = new BoundedQueue( 2 );
		queue.enQueue( 0 );
		queue.enQueue( 1 );
		assertThrows( IllegalStateException.class, () -> queue.enQueue( 0 ) );
	}
	
	@Test
	public void enqueue4() {
		BoundedQueue queue = new BoundedQueue( 2 );
		queue.enQueue( 0 );
		assertEquals( queue.get(0), 0 );
	}
	
	@Test
	public void enqueue5() {
		BoundedQueue queue = new BoundedQueue(0);
		assertThrows( IllegalStateException.class, () -> queue.enQueue( 0 ) );
	}
	
	@Test
	public void dequeue1() {
		BoundedQueue queue = new BoundedQueue(2);
		queue.enQueue(0);
		assertEquals( queue.deQueue(), 0 );
	}
	
	@Test
	public void dequeue2() {
		BoundedQueue queue = new BoundedQueue(1);
		queue.enQueue(0);
		assertEquals( queue.deQueue(), 0 );
	}
	
	@Test
	public void dequeue3() {
		BoundedQueue queue = new BoundedQueue(1);
		assertThrows( IllegalStateException.class, () -> queue.deQueue() );
	}
	
	@Test
	public void dequeue4() {
		BoundedQueue queue = new BoundedQueue(0);
		assertThrows( IllegalStateException.class, () -> queue.deQueue() );
	}
	
	@Test
	public void isEmptyNIsFull1() {
		BoundedQueue queue = new BoundedQueue(2);
		queue.enQueue(0);
		assertFalse( queue.isEmpty() && !queue.isFull() );
	}
	
	@Test
	public void isEmptyNIsFull2() {
		BoundedQueue queue = new BoundedQueue(1);
		queue.enQueue(0);
		assertFalse( queue.isEmpty() && queue.isFull() );
	}
	
	@Test
	public void isEmptyNIsFull3() {
		BoundedQueue queue = new BoundedQueue(1);
		assertTrue( queue.isEmpty() && !queue.isFull() );
	}
	
	@Test
	public void isEmpty4() {
		BoundedQueue queue = new BoundedQueue(0);
		assertTrue( queue.isEmpty() && queue.isFull() );
	}
}
