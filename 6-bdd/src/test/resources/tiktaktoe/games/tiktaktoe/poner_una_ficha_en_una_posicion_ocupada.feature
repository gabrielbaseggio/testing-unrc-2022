# language : es
Característica: Meter una ficha en un casillero ocupado no produce ningun cambio.

  Escenario: Meter ficha en un casillero ocupado
  Dado que meti una X en la posicion 2 2
  Cuando meto una O en la posicion 2 2
  Y pregunto por la posicion 2 2
  Entonces deberia obtener una X
