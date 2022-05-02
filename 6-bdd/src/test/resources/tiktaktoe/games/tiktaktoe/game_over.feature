Feature: game over

Background:
Given that the app has been initialized

Scenario: game is over after putting three adjacent X
  Given I put an X in the position 0 0
  And I put an O in the position 0 1
  And I put an X in the position 1 1
  And I put an O in the position 1 2
  And I put an X in the position 2 2
  When I ask the system if the game is over
  Then I should get true

Scenario: X is the winner after putting three adjacent X
  Given I put an X in the position 0 0
  And I put an O in the position 0 1
  And I put an X in the position 1 1
  And I put an O in the position 1 2
  And I put an X in the position 2 2
  When I ask the system who's the winner
  Then I should get an X