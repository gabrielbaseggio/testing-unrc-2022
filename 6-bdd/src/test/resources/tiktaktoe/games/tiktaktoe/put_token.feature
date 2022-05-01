Feature: put token

Background:
Given that the app has been initialized

Scenario: putting a token when the game start
  When I put an X in the position 2 2
  And I ask the system for the position 2 2
  Then I should get that the position 2 2 is occupied
  
Scenario: putting a token on an occupied position
  Given I put an X in the position 2 2
  When I put an O in the position 2 2
  And I ask the system for the position 2 2
  Then I should get that the poisition 2 2 is occupied by an X
  
Scenario: game is over after putting three adjacent X
  Given that the board is in the state
      | X     | O       | O     |
      | IDDLE | X       | IDDLE |
      | IDDLE | IDDLE   | IDDLE |
  When I put an X in the posicion 2 2
  And I ask the system if the game is over
  Then I should get true
