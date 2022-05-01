package ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestStringCalculator {
    @Test
    public void StringCalculatorEmptyString() {
    	assertEquals( StringCalculator.Add( "" ), 0 );
    }
    
    @ParameterizedTest
    @CsvSource({
    	"1,1",
    	"2,2",
    	"3,3",
    	"'1,2',3",
    	"'2,1',3",
    	"'1,2,3', 6",
    	"'4,5,6', 15"
    })
    public void StringCalculatorParameterizedTest( String s, int expected ) {
    	assertEquals( StringCalculator.Add( s ), expected );
    }
}
