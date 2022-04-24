package testing.parameterized.teoria;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import testing.parameterized.practico.ejercicio2.MinList;

public class MinListFromString extends SimpleArgumentConverter {
	@Override
	protected Object convert(Object source, Class<?> targetType) {
		String strSource = ((String)source);
		if(strSource.equals("null")) return null;
		strSource = strSource.substring(1, strSource.length()-1);
		String [] strArray = strSource.split(",");
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < strArray.length; i++) 
			if(strArray[i].equals("null")) {
				res.add(null);
			} else if(!strArray[i].isEmpty()) {
				res.add(Integer.parseInt(strArray[i]));
			}
		return new MinList<>(res);
	}
}