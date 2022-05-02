# language: es
Característica: Ganador del juego

Escenario: Ganar el juego
  Dado que la aplicación ha sido iniciada
  Y hay un juego en curso
  Y el jugador inicial es X
  Cuando el jugador X pone una ficha en la celda (0,0)
  Y el jugador O pone una ficha en la celda (0,1)
  Y el jugador X pone una ficha en la celda (1,1)
  Y el jugador X pone una ficha en la celda (0,2)
  Y el jugador X pone una ficha en la celda (2,2)
  Entonces el jugador X es el ganador
