package testing.propertybased.teoria;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import testing.propertybased.practico.ejercicio4.BoundedQueue;

public class BoundedQueueFromString extends SimpleArgumentConverter {
	
	@Override
	protected Object convert(Object source, Class<?> targetType) {
		String strSource = ((String)source);
		if(strSource.equals("null")) return null;
		int capacity = Integer.parseInt(strSource.substring(0, 1));
		strSource    = strSource.substring(3, strSource.length()-1);
		String [] strArray = strSource.split(",");
		BoundedQueue queue = new BoundedQueue( capacity );
		for (int i = 0; i < strArray.length; i++) 
			if(!strArray[i].isEmpty()) {
				queue.enQueue(Integer.parseInt(strArray[i]));
			}
		return queue;
	}
}

