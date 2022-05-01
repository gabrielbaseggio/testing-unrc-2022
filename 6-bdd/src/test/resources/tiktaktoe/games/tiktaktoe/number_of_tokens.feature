Feature: number of tokens

Background:
  Given that the app has been initialized

  Scenario: number of tokens when the game start
    When I ask the system for the number of tokens on the board
    Then I should get 0
    
  Scenario: number of tokens after putting the firt one
    Given I put an X in the position 2 2
    When I ask the system for the number of tokens on the board
    Then I should get 1
