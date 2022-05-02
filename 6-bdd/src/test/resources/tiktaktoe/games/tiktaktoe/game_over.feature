Feature: game over

Background:
Given that the app has been initialized
And I tell the system that the player X is the starting player

Scenario: game is over after putting three adjacent X
  Given X put a token in the position 0 0
  And O put a token in the position 0 1
  And X put a token in the position 1 1
  And O put a token in the position 1 2
  And X put a token in the position 2 2
  When I ask the system if the game is over
  Then I should get true

Scenario: X is the winner after putting three adjacent X
  Given X put a token in the position 0 0
  And O put a token in the position 0 1
  And X put a token in the position 1 1
  And O put a token in the position 1 2
  And X put a token in the position 2 2
  When I ask the system who's the winner
  Then I should get an X
