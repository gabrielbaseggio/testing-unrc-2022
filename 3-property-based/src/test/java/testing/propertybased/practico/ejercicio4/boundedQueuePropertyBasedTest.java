package testing.propertybased.practico.ejercicio4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Report;
import net.jqwik.api.Reporting;

public class boundedQueuePropertyBasedTest {
	
	private int capacity = 5;
	
	/**
	 * helper method to copy a BoundedQueue
	 * @param q queue to copy
	 * @return new queue from elements of param queue
	 */
    private static BoundedQueue copyQueue(BoundedQueue q) {
		BoundedQueue res = new BoundedQueue( q.size() );
		
		for (Object obj: q) {
			res.enQueue(obj);
		}
		
		return res;
	}
    
    /**
     * input generator method
     * @return test inputs
     */
    @Provide
	Arbitrary<BoundedQueue> myBoundedQueuesOfInteger() {
		Arbitrary<Set<Integer>> sets = Arbitraries.integers()
				.between(0, 5)
				.set()
				.ofMaxSize(capacity);
		return sets.map( s -> new BoundedQueue( s, capacity ) );
	}
	
	/**
	 * queuing an element in a non-full queue increases the size by 1.
	 * @param queue test queue
	 */
    @Property 
    @Report(Reporting.GENERATED)
    void queuingIncreasesTheSize( 
    		@ForAll("myBoundedQueuesOfInteger") BoundedQueue queue) {
    	assumeTrue( !queue.isFull() );
    	
    	int sizeOrig = queue.size();
    	queue.enQueue( 0 );
    	
    	assertThat( queue ).hasSize( sizeOrig + 1 );
    }
	
	/**
	 * dequeuing an element in a non-empty queue decreses the size by 1.
	 * @param queue test queue
	 */
    @Property 
    @Report(Reporting.GENERATED)
	void dequeuingDecreasesTheSize( 
			@ForAll("myBoundedQueuesOfInteger") BoundedQueue queue) {
		assumeTrue( !queue.isEmpty() );
		
		int sizeOrig = queue.size();
		queue.deQueue();
		
		assertThat( queue ).hasSize( sizeOrig - 1 );
	}
	
	/**
	 * enqueueing an element x in a queue q results in a queue q' such that q' is q concatenated at the end with x
	 * @param queue test queue
	 */
    @Property 
    @Report(Reporting.GENERATED)
	void boundedQueuePropertyenQueue1( 
			@ForAll("myBoundedQueuesOfInteger") BoundedQueue queue) {
		assumeTrue( !queue.isFull() && !queue.isEmpty() );
		
		BoundedQueue orig = copyQueue( queue );
		
		Integer e = 0;
		
		queue.enQueue( e );

		assertThat( queue ).hasSize( orig.size() + 1 );
		assertThat( queue ).containsSequence( orig );
		assertThat( queue ).endsWith( e );
		
	}
    
    @Test
    void boundedQueuePropertyenQueue2() {
    	BoundedQueue queue = new BoundedQueue( 1 );
    	
    	BoundedQueue orig = copyQueue( queue );
    	
    	Integer e = 0;
    	
    	queue.enQueue( e );
    	
    	assertThat( queue ).hasSize( orig.size() + 1 );
    	//assertThat( queue ).containsSequence( orig );
    	assertThat( queue ).endsWith( e );
    }
	
	/**
	 * dequeuing an element x1 from queue q = [x1, ...] results in a queue q' such that the size of q' is the size of q decreased by 1 and
	 * q contains the sequence q'.
	 * @param queue test queue
	 */
    @Property 
    @Report(Reporting.GENERATED)
	void boundedQueuePropertydeQueue1( 
			@ForAll("myBoundedQueuesOfInteger") BoundedQueue queue) {
		assumeTrue( queue.size() > 1 );
		
		BoundedQueue orig = copyQueue( queue );
		
		Object e = queue.deQueue();

		assertThat( queue ).hasSize( orig.size() - 1 );
		assertThat( orig ).containsSequence( queue );
		assertThat( orig ).startsWith( e );
		
	}
	
    @Test
	void boundedQueuePropertydeQueue2() {
		BoundedQueue queue = new BoundedQueue( 1 );
		queue.enQueue( 1 );
		
		BoundedQueue orig = copyQueue( queue );
		
		Object e = queue.deQueue();

		assertThat( queue ).isEmpty();
		assertThat( orig ).startsWith( e );
	}
}
