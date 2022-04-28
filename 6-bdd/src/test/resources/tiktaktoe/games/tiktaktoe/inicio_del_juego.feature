# language : es
Característica: Cuando se inicia el juego, la cantidad de fichas en el tablero es 0.

  Escenario: Comienzo de juego por defecto
    Dado que la aplicacion ha sido iniciada
    Cuando pregunto por la cantidad de fichas en el tablero
    Entonces deberia obtener 0.
