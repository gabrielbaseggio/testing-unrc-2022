package testing.propertybased.practico.ejercicio4;

import java.util.Collection;
import java.util.Iterator;

//Introduction to Software Testing
//Authors: Paul Ammann & Jeff Offutt

public class BoundedQueue implements Iterable<Object>
{ 
	// Overview:  a BoundedQueue is a mutable, bounded FIFO data structure
	// of fixed size , with size being set in the constructor
	// A typical Queue is [], [o1], or [o1, o2], where neither o1 nor o2
	// are ever null.  Older elements are listed before newer ones.

	private final Object[] elements;
	private int size, front, back;
	private final int capacity;

	public BoundedQueue (int capacity)
	{
		if (capacity < 0)
			throw new IllegalArgumentException ("BoundedQueue.constructor");
		this.capacity = capacity;
		elements = new Object [capacity];
		size  = 0; front = 0; back  = 0;
	}
	
	public BoundedQueue ( Collection<?> c, int capacity ) {
		if( capacity < 0 ) {
			throw new IllegalArgumentException ("BoundedQueue.constructor");
		}else if( c.size() > capacity ) {
			throw new IllegalArgumentException ("BoundedQueue.constructor");
		}
		
		this.capacity = capacity;
		elements = new Object [capacity];
		size  = 0; front = 0; back  = 0;
		
		for( Object o : c ) {
			size++;
			elements [back] = o;
			back = (back+1) % capacity;
		}
	}

	public void enQueue (Object o)
			throws NullPointerException, IllegalStateException
	{  // Modifies: this
		// Effects:   If argument is null throw NullPointerException
		// else if this is full, throw IllegalStateException,
		// else make o the newest element of this
		if (o == null)
			throw new NullPointerException ("BoundedQueue.enQueue");
		else if (size == capacity)
			throw new IllegalStateException ("BoundedQueue.enQueue");
		else
		{
			size++;
			elements [back] = o;
			back = (back+1) % capacity;
		}
	}

	public Object deQueue () throws IllegalStateException
	{  // Modifies: this
		// Effects:   If queue is empty, throw IllegalStateException,
		// else remove and return oldest element of this

		if (size == 0)
			throw new IllegalStateException ("BoundedQueue.deQueue");
		else
		{
			size--;
			Object o = elements [ (front % capacity) ];
			elements [front] = null;
			front = (front+1) % capacity;
			return o;
		}
	}

	public boolean isEmpty()
	{ 
		return (size == 0); 
	}

	public boolean isFull() 
	{ 
		return (size == capacity); 
	}

	public String toString()
	{
		String result = "[";
		for (int i = 0; i < size; i++)
		{
			result += elements[ (front + i) % capacity ] . toString();
			if (i < size -1) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
	
	public int size() {
		return size;
	}

	@Override
	public Iterator<Object> iterator() {
		return new BoundedQueueIterator( elements, size, front, capacity );
	}

}