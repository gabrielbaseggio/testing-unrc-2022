# language : es
Característica: Cuando se inicia el juego, se muestra un tablero c con ningun casillero ocupado.

  Escenario: Comienzo de juego por defecto
    Dado que la aplicacion ha sido iniciada
    Cuando pregunto por la cantidad de fichas en el tablero
    Entonces deberia obtener 0.
