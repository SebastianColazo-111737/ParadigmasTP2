
package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.falopa.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {

  @Test
  public void jugadorPuedeColocarUnaCartaEnUnaSeccion() {
    // Arrange
    Juego juego = GameFactory.crearJuego("Player1", "player2");
    juego.repartirCartasDelMazoJugador(0);

    // Act
    juego.colocarCarta(0, 2, 0);

    // Assert
    assertEquals(1, juego.cantidadCartasEnSeccion(0));
  }

  @Test
  public void juegoCalculaElPuntajeDelJugador() {
    // Arrange
    Juego juego = GameFactory.crearJuego("Player1", "player2");
    juego.repartirCartasDelMazoJugador(0);

    // Act
    juego.colocarCarta(0, 0, 0);

    // Assert
    assertEquals(16, juego.getPuntajeJugador(0));
  }
}
