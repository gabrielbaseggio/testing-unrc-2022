# language : es
Característica: Meter una ficha en una posicion libre del tablero hace que esa posicion pase a estar ocupada.

  Escenario: poner ficha en un casillero valido
    Dado que la aplicacion ha sido iniciada
    Y meto una ficha en la posicion (x,y)
    Cuando pregunto por la posicion (x,y)
    Entonces deberia obtener que la posicion esta ocupada
