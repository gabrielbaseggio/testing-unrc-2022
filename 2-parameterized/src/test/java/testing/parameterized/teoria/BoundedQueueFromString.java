package testing.parameterized.teoria;

import java.util.ArrayList;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import testing.parameterized.practico.ejercicio3.BoundedQueue;

public class BoundedQueueFromString extends SimpleArgumentConverter {
	
	private int QUEUE_MAX = 100;
	
	@Override
	protected Object convert(Object source, Class<?> targetType) {
		String strSource = ((String)source);
		if(strSource.equals("null")) return null;
		strSource = strSource.substring(1, strSource.length()-1);
		String [] strArray = strSource.split(",");
		BoundedQueue queue = new BoundedQueue( QUEUE_MAX );
		for (int i = 0; i < strArray.length; i++) 
			if(!strArray[i].isEmpty()) {
				queue.enQueue(Integer.parseInt(strArray[i]));
			}
		return queue;
	}
}

