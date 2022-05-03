package tictactoe;

import io.cucumber.java.ParameterType;

import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InitStepDefinitions {
	
	TaTeTi juego;
	Ficha ganador;
	boolean juegoTerminado;
	
	@Dado("que la aplicación ha sido iniciada")
	public void que_la_aplicacion_ha_sido_iniciada() {
	    // Write code here that turns the phrase above into concrete actions
		juego = new TaTeTi();
	}

	@Cuando("se crea un nuevo juego")
	public void se_crea_un_nuevo_juego() {
	    // Write code here that turns the phrase above into concrete actions
		juego.iniciarJuego();
	}

	@Entonces("el tablero no tiene fichas")
	public void el_tablero_no_tiene_fichas() {
		assertTrue(juego.tableroVacio());
	}
	
	@Dado("hay un juego en curso")
	public void hay_un_juego_en_curso() {
		juego.iniciarJuego();
	}

	@Dado("es el turno del jugador {ficha}")
	public void es_el_turno_del_jugador(Ficha player) {

	}

	@Dado("no hay ficha en la posición \\({int},{int}\\)")
	public void no_hay_ficha_en_la_posición(int x, int y) {

	}

	@Cuando("el jugador {ficha} pone una ficha en la celda \\({int},{int}\\)")
	public void el_jugador_pone_una_ficha_en_la_celda(Ficha ficha, int x, int y) {
		//juego.colocarFichaEn(Ficha.X, x, y);
		juego.jugarEn(x, y);
	}

	@Entonces("el tablero tiene una {ficha} en la celda \\({int},{int}\\)")
	public void el_tablero_tiene_una_x_en_la_celda(Ficha ficha, int x, int y) {
	    assertEquals( juego.ficha(x,y), ficha );
	}
	
	@Dado("el jugador inicial es {ficha}")
	public void el_jugador_inicial_es( Ficha ficha ) {
	    juego.jugadorInicial( ficha );
	}
	
	@Dado("el estado del juego es el siguiente")
	public void el_estado_del_juego_es_el_siguiente(io.cucumber.datatable.DataTable dataTable) {
	    
	}
	
	@Cuando("le pregunto al sistema si el juego termino")
	public void le_pregunto_al_sistema_si_el_juego_termino() {
	    juegoTerminado = juego.termino();
	}
	
	@Cuando("le pregunto al sistema quien es el ganador")
	public void le_pregunto_al_sistema_quien_es_el_ganador() {
	    ganador = juego.ganador();
	}
	
	@Entonces("deberia obtener {valorBooleano}")
	public void deberia_obtener( boolean valorBooleano ) {
	    
	}
	
	@Entonces("deberia obtener {ficha}")
	public void deberia_obtener( Ficha ficha ) {
	    
	}



	@ParameterType("X|O")
	public Ficha ficha( String valor ) {
		return Ficha.valueOf( valor );
	}
	
	@ParameterType("true|false")
	public boolean valorBooleano( String valor ) {
		return Boolean.getBoolean( valor );
	}
}
