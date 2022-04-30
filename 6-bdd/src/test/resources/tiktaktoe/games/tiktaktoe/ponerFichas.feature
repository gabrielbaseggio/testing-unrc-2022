# language : es

Antecedentes: Inicio de la aplicacion por defecto
  Dado que la aplicacion ha sido iniciada
  
  Escenario: Meter una ficha al inicio del juego
    Cuando meto una ficha en la posicion 2 2
    Y pregunto por la posicion 2 2
    Entonces deberia obtener que dicha posicion esta ocupada.
    
  Escenario: Meter una ficha en un casillero ocupado
    Dado que meti una X en la posicion 2 2
    Cuando meto una O en la posicion 2 2
    Y pregunto por la posicion 2 2
    Entonces deberia obtener una X.
