# language : es
Característica: Cuando se inicia el juego, el tablero esta vacio y por ende puedo meter una ficha en cualquier posicion.

  Escenario: Meter una ficha al inicio del juego
    Dado que la aplicacion ha sido iniciada
    Cuando meto una ficha en la posicion 2 2
    Y pregunto por la posicion 2 2
    Entonces deberia obtener que dicha posicion esta ocupada.
