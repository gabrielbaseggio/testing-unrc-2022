# language : es

Característica: Cuando se inicia el juego, el tablero esta vacio y por ende si meto una ficha la cantidad de fichas se incremento en 1.

  Escenario: Poner una ficha al inicio del juego
    Dado que la aplicacion ha sido iniciada
    Cuando meto una ficha en la posicion 2 2
    Y pregunto por la cantidad de fichas en el tablero
    Entonces deberia obtener que la cantidad de fichas es 1.
