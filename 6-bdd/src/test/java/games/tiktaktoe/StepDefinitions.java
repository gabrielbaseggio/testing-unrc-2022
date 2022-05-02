package games.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	TikTakToe tiktaktoe;
	Token token;
	boolean gameIsOver;
	int nTokens;

	@Given("that the app has been initialized")
	public void that_the_app_has_been_initialized() {
	    tiktaktoe = new TikTakToe();
	}

	@When("I ask the system for the number of tokens on the board")
	public void i_ask_the_system_for_the_number_of_tokens_on_the_board() {
	    nTokens = tiktaktoe.tokens();
	}
	
	@Then("I should get {int}")
	public void i_should_get(Integer int1) {
	    assertEquals( nTokens, int1 );
	}
	
	@Given("I put an {tokenValue} in the position {int} {int}")
	public void i_put_an_x_in_the_position(Token token, Integer int1, Integer int2) {
	    tiktaktoe.put(int1, int2);
	}
	
	@When("I ask the system for the position {int} {int}")
	public void i_ask_the_system_for_the_position(Integer int1, Integer int2) {
	    token = tiktaktoe.get(int1, int2);
	}
	
	@Then("I should get that the position {int} {int} is occupied by an {tokenValue}")
	public void i_should_get_that_the_poisition_is_occupied_by_an(Integer int1, Integer int2, Token tokenValue) {
	    assertEquals( token, tokenValue );
	}
	
	@Given("I tell the system that player {tokenValue} is the starting player")
	public void i_tell_the_system_that_player_is_the_starting_player( Token tokenValue ) {
	    tiktaktoe.setStartingPlayer( tokenValue );
	}
	
	@When("I ask the system who's the current player")
	public void i_ask_the_system_who_s_the_current_player() {
	    token = tiktaktoe.currentPlayer();
	}
	
	@Then("I should get an {tokenValue}")
	public void i_should_get_an( Token tokenValue ) {
	    assertEquals( token, tokenValue );
	}

	@When("I ask the system if the game is over")
	public void i_ask_the_system_if_the_game_is_over() {
	    gameIsOver = tiktaktoe.gameIsOver();
	}
	
	@ParameterType("true|false")
	public Boolean booleanValue( String value ) {
		return Boolean.valueOf( value );
	}
	
	@ParameterType("X|O|IDDLE")
	public Token tokenValue( String value ) {
		return Token.valueOf( value );
	}
	
	@Then("I should get {booleanValue}")
	public void i_should_get( Boolean value ) {
	    assertEquals( gameIsOver, value );
	}

	@When("I ask the system who's the winner")
	public void i_ask_the_system_who_s_the_winner() {
	    token = tiktaktoe.whosTheWinner();
	}
}
