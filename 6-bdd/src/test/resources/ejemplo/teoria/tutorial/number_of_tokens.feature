Feature: number of tokens

Background:
  Given that the app has been initialized

  Scenario: number of tokens when the game start
    When I ask the system for the number of tokens on the board
    Then I should get 0
