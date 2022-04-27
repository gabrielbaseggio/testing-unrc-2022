package games.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class StepDefinitions {
	
	 TikTakToe tiktaktoe;
	 int tokens;
	
	@Dado("que la aplicacion ha sido iniciada")
	public void que_la_aplicacion_ha_sido_iniciada() {
	    tiktaktoe = new TikTakToe();
	}

	@Cuando("pregunto por la cantidad de fichas en el tablero")
	public void pregunto_por_la_cantidad_de_fichas_en_el_tablero() {
	    tokens = tiktaktoe.tokens();
	}

	@Entonces("deberia obtener {int}.")
	public void deberia_obtener(Integer int1) {
	    assertEquals( tokens, int1 );
	}


}
