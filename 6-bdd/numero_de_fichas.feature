 Scenario: Comienzo de juego por defecto
   Given que la aplicacion ha sido iniciada
   When pregunto por la cantidad de fichas en el tablero
   Then deberia obtener 0.
    
 Scenario: Poner una ficha al inicio del juego
   Given que la aplicacion ha sido iniciada
   When meto una ficha en la posicion 2 2
   And pregunto por la cantidad de fichas en el tablero
   Then deberia obtener que la cantidad de fichas es 1.
