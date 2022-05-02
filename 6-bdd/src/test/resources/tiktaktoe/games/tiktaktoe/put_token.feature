Feature: put token

Background:
Given that the app has been initialized

Scenario: putting a token when the game start
  Given I put an X in the position 2 2
  And I ask the system for the position 2 2
  Then I should get that the position 2 2 is occupied by an X
  
Scenario: putting a token on an occupied position
  Given I put an X in the position 2 2
  And I put an O in the position 2 2
  When I ask the system for the position 2 2
  Then I should get that the position 2 2 is occupied by an X
