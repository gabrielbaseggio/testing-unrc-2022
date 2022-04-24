package ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestStringCalculator {
    @Test
    public void StringCalculatorEmptyString() {
    	assertEquals( StringCalculator.Add( "" ), 0 );
    }
    
    @Test
    public void StringCalculatorOne() {
    	assertEquals( StringCalculator.Add( "1" ), 1 );
    }
    
    @Test
    public void StringCalculatorTwo() {
    	assertEquals( StringCalculator.Add( "2" ), 2 );
    }
    
    @Test
    public void StringCalculatorThree() {
    	assertEquals( StringCalculator.Add( "3" ), 3 );
    }
}
