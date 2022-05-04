# language: es
Característica: El turno cambia al hacer un movimiento

Escenario: El jugador X realiza un movimiento y el turno pasa al jugador O
  Dado que la aplicación ha sido iniciada
  Y hay un juego en curso
  Y el jugador actual es X
  Y el estado del juego es el siguiente
  |   |   |   |
  |   |   |   |
  |   |   |   |
  Cuando el jugador X pone una ficha en la celda (0,0)
  Y el jugador O pone una ficha en la celda (0,1)
  Y el jugador X pone una ficha en la celda (0,2)
  Entonces el jugador actual es O
  Y el juego queda como
  | X | O | X |
  |   |   |   |
  |   |   |   |
