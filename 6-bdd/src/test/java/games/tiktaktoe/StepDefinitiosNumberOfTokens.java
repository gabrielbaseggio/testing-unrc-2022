package games.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitiosNumberOfTokens {
	
	TikTakToe tiktaktoe;
	Token token;
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
	
	@Given("I put an X in the position {int} {int}")
	public void i_put_an_x_in_the_position(Integer int1, Integer int2) {
	    tiktaktoe.put(int1, int2);
	}
	
	@When("I ask the system for the position {int} {int}")
	public void i_ask_the_system_for_the_position(Integer int1, Integer int2) {
	    token = tiktaktoe.get(int1, int2);
	}

	@Then("I should get that the position {int} {int} is occupied")
	public void i_should_get_that_the_position_is_occupied(Integer int1, Integer int2) {
	    assertFalse( token.equals( Token.IDDLE ) );
	}
	
	@When("I put an O in the position {int} {int}")
	public void i_put_an_o_in_the_position(Integer int1, Integer int2) {
	    tiktaktoe.put(int1, int2);
	}
	
	@Then("I should get that the poisition {int} {int} is occupied by an X")
	public void i_should_get_that_the_poisition_is_occupied_by_an_x(Integer int1, Integer int2) {
	    assertEquals( token, Token.X );
	}
	
	@Given("I tell the system that player X is the starting player")
	public void i_tell_the_system_that_player_x_is_the_starting_player() {
	    tiktaktoe.setStartingPlayer( Token.X );
	}
	
	@When("I ask the system who's the current player")
	public void i_ask_the_system_who_s_the_current_player() {
	    token = tiktaktoe.currentPlayer();
	}
	
	@Then("I should get an O")
	public void i_should_get_an_o() {
	    assertEquals( token, Token.O );
	}
	
	@Given("I tell the system that player O is the starting player")
	public void i_tell_the_system_that_player_o_is_the_starting_player() {
	    tiktaktoe.setStartingPlayer( Token.O );
	}
	
	@Then("I should get an X")
	public void i_should_get_an_x() {
	    assertEquals( token, Token.X );
	}

	@Given("that the board is in the state")
	public void that_the_board_is_in_the_state(io.cucumber.datatable.DataTable dataTable) {
	    List<Token> tokenList = dataTable.asList( Token.class );
	    tiktaktoe = new TikTakToe( tokenList );
	}


}
