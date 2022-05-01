package games.tiktaktoe;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class TikTakToeFromString extends SimpleArgumentConverter {
	@Override
	protected Object convert( Object source, Class<?> targetType ) {
		String strSource = ((String)source);
		if(strSource.equals("null")) return null;
		strSource = strSource.substring(1, strSource.length()-1);
		String [] strArray = strSource.split(",");
		TikTakToe tiktaktoe = new TikTakToe();
		Token token;
		for( int i = 0; i < strArray.length; i++ ) {
			token = Token.IDDLE;
			if( strArray[i].equals( "X" ) ) {
				token = Token.X;
			} else if( strArray[i].equals( "O" ) ) {
				token = Token.O;
			}
			
			tiktaktoe.put(i / 3, i % 3, token );
		}
		
		return tiktaktoe;
	}
}
