package testing.parameterized.practico.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import testing.parameterized.teoria.BoundedQueueFromString;

public class boundedQueueTestsParametrizadosCSV {
	@ParameterizedTest(name = "{index}: queue {0} after enQueued {1} element is {2}")
	@CsvSource({ 
		"'[1]',0,'[1, 0]'",
		"'[]',1,[1]",
		"'[0,1,0,1,0]',1,'[0, 1, 0, 1, 0, 1]'"
	})
	void boundedQueueSizeAfterEnqueueParamTest(@ConvertWith(BoundedQueueFromString.class) BoundedQueue queue, int e, String expected) {
		queue.enQueue(e);
		boolean res = expected.equals(queue.toString());
		assertTrue(res);
	}
	
	@ParameterizedTest(name = "{index}: dequeued element in {0} is {1}")
	@CsvSource({ 
		"'[0,1]', 0",
		"'[1]', 1"
	})
	void boundedQueuedeQueueParamTest(@ConvertWith(BoundedQueueFromString.class) BoundedQueue queue, int expected) {
		int result = (int)queue.deQueue();
		assertEquals(expected, result);
	}
	
	@Test
	void boundedQueueEmptyDeQueueTest() {
		BoundedQueue queue = new BoundedQueue(0);
		assertThrows(IllegalStateException.class, () -> queue.deQueue());
	}
	
	@Test
	void boundedQueueNotPositiveCapacityTest() {
		assertThrows(IllegalArgumentException.class, () -> new BoundedQueue(-1) );
	}
}