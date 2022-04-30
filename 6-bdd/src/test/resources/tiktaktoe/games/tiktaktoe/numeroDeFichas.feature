# language : es

Antecedentes: Inicio de la aplicacion por defecto
  Dado que la aplicacion ha sido iniciada
  
  Escenario: Comienzo de juego por defecto
    Cuando pregunto por la cantidad de fichas en el tablero
    Entonces deberia obtener 0.
    
  Escenario: Poner una ficha al inicio del juego
    Cuando meto una ficha en la posicion 2 2
    Y pregunto por la cantidad de fichas en el tablero
    Entonces deberia obtener que la cantidad de fichas es 1.
