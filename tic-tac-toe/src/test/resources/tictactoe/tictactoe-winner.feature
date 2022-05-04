# language: es
Característica: Ganador del juego

Escenario: Ganar el juego
  Dado que la aplicación ha sido iniciada
  Y hay un juego en curso
  Y el jugador actual es X
  Y el estado del juego es el siguiente
  | X | O |   |
  |   | X | O |
  |   |   |   |
  Cuando el jugador X pone una ficha en la celda (2,2)
  Entonces el juego termino
  Y X es el ganador
  Y el estado del juego es el siguiente
  | X | O |   |
  |   | X | O |
  |   |   | X |
