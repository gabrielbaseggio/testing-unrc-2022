package testing.propertybased.practico.ejercicio4;

import java.util.Iterator;

public class BoundedQueueIterator implements Iterator<Object> {
	
	Object[] queue;
	int capacity;
	int size;
	int front;
	int position;
	
	public BoundedQueueIterator( Object[] queue, int size, int front, int capacity ) {
		this.queue    = queue.clone();
		this.size     = size;
		this.front    = front;
		this.capacity = capacity;
		this.position = 0;
	}

	@Override
	public boolean hasNext() {
		if( position < size ) return true;
		return false;
	}

	@Override
	public Object next() {
		Object e = queue[(front + position) % capacity]; 
		position++;
		return e;
	}

}
