# language: es
Característica: Ganador del juego

Escenario: Ganar el juego
  Dado que la aplicación ha sido iniciada
  Y hay un juego en curso
  Y el jugador inicial es X
  Y el estado del juego es el siguiente
  | X | O |   |
  |   | X | O |
  |   |   |   |
  Cuando el jugador X pone una ficha en la celda (2,2)
  Y le pregunto al sistema si el juego termino
  Y le pregunto al sistema quien es el ganador
  Entonces deberia obtener true
  Y deberia obtener X
