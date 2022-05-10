# language: es
Característica: El estado del juego no cambia al hacer un movimiento invalido

Escenario: El jugador X intenta realizar un movimiento en una celda ocupada
  Dado que la aplicación ha sido iniciada
  Y hay un juego en curso
  Y el jugador actual es X
  Y el estado del juego es el siguiente
  | X | O |   |
  |   | O |   |
  |   |   | X |
  Cuando el jugador X pone una ficha en la celda (1,1)
  Entonces la jugada es invalida
  Y el jugador actual es X
  Y el juego queda como
  | X | O |   |
  |   | O |   |
  |   |   | X |

Escenario: El jugador X intenta realizar un movimiento en una celda invalida
  Dado que la aplicación ha sido iniciada
  Y hay un juego en curso
  Y el jugador actual es X
  Y el estado del juego es el siguiente
  |   |   | X |
  |   |   | O |
  |   |   |   |
  Cuando el jugador X pone una ficha en la celda (3,3)
  Entonces la jugada es invalida
  Y el jugador actual es X
  Y el juego queda como 
  |   |   | X |
  |   |   | O |
  |   |   |   |