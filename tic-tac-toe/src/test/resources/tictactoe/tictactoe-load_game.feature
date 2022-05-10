# language: es
Característica: Cargar un juego

Escenario: Cargar un juego durante una partida en curso
  Dado que la aplicación ha sido iniciada
  Y hay un juego en curso
  Y el jugador actual es O
  Y el estado del juego es el siguiente
  | X | O | X |
  |   |   |   |
  |   |   |   |
  Cuando se carga el siguiente juego con jugador actual X
  | O | X | O |
  |   |   |   |
  |   |   |   |
  Entonces el juego queda como
  | O | X | O |
  |   |   |   |
  |   |   |   |
  Y el jugador actual es X

Escenario: Cargar un juego con max de dos X's que O's
  Dado que la aplicación ha sido iniciada
  Y hay un juego en curso
  Y el jugador actual es X
  Y el estado del juego es el siguiente
  |   |   |   |
  |   |   |   |
  |   |   |   |
  Cuando se carga el siguiente juego con jugador actual X
  | X | X | X |
  |   | O |   |
  |   |   |   |
  Entonces el juego cargado es invalido
  Y el jugador actual es X
  Y el juego queda como
  |   |   |   |
  |   |   |   |
  |   |   |   |