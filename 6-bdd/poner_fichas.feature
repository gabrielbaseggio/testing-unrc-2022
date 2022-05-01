  Background:
  Given que la aplicacion ha sido iniciada
  
  Scenario: Meter una ficha al inicio del juego
    When meto una ficha en la posicion 2 2
    And pregunto por la posicion 2 2
    Then deberia obtener que dicha posicion esta ocupada.
    
  Escenario: Meter una ficha en un casillero ocupado
    Given que meti una X en la posicion 2 2
    When meto una O en la posicion 2 2
    And pregunto por la posicion 2 2
    Then deberia obtener una X.
