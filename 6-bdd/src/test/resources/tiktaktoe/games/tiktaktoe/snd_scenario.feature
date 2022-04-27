# language : es
Característica: Cuando se inicia el juego, se muestra un tablero c con ningun casillero ocupado.

  Escenario: poner ficha en un casillero valido
    Dado que la aplicacion ha sido iniciada
    Y meto una ficha en la posicion (x,y)
    Cuando pregunto por el estado del tablero
    Entonces deberia ver que la posicion (x,y) esta ocupado.
