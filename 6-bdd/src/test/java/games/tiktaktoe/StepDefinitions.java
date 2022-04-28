package games.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class StepDefinitions {
	
	 TikTakToe tiktaktoe;
	 Token token;
	 int tokens;
	
	@Dado("que la aplicacion ha sido iniciada")
	public void que_la_aplicacion_ha_sido_iniciada() {
	    tiktaktoe = new TikTakToe();
	}
	
	@Dado("que meti una X en la posicion {int} {int}")
	public void que_meti_una_x_en_la_posicion(Integer int1, Integer int2) {
	    tiktaktoe.put(int1, int2, Token.X);
	}

	@Cuando("pregunto por la cantidad de fichas en el tablero")
	public void pregunto_por_la_cantidad_de_fichas_en_el_tablero() {
	    tokens = tiktaktoe.tokens();
	}

	@Entonces("deberia obtener {int}.")
	public void deberia_obtener(Integer int1) {
	    assertEquals( tokens, int1 );
	}
	
	@Cuando("meto una ficha en la posicion {int} {int}")
	public void meto_una_ficha_en_la_posicion(Integer int1, Integer int2) {
	    tiktaktoe.put( int1, int2, Token.X );
	}
	
	@Cuando("pregunto por la posicion {int} {int}")
	public void pregunto_por_la_posicion(Integer int1, Integer int2) {
	    token = tiktaktoe.get( int1, int2 );
	}

	@Entonces("deberia obtener que dicha posicion esta ocupada.")
	public void deberia_obtener_que_dicha_posicion_esta_ocupada() {
	    assertFalse( token.equals( Token.IDDLE ) );
	}

	@Entonces("deberia obtener que la cantidad de fichas es {int}.")
	public void deberia_obtener_que_la_cantidad_de_fichas_es(Integer int1) {
	    assertEquals( tokens, int1 );
	}

}
