Feature: player change

Background:
Given that the app has been initialized

Scenario: player change to O after putting a token
  Given I tell the system that player X is the starting player
  When I put an X in the position 2 2
  And I ask the system who's the current player
  Then I should get an O
  
Scenario: player change to X after putting a token
  Given I tell the system that player O is the starting player
  When I put an O in the position 2 2
  And I ask the system who's the current player
  Then I should get an X
