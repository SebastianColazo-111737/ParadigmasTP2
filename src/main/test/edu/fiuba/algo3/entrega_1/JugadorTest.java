package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.falopa.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

  @Test
  public void jugadorMazoTest() {
    // Arrange
    Mazo mazo = GameFactory.crearMazo();

    // Act
    Jugador jugador = new Jugador("Player1", mazo);

    // Assert
    assertEquals(21, jugador.cartasEnElMazo());
  }

  @Test
  public void jugadorManoTest() {

    // Arrange
    Jugador jugador = new Jugador("Player1", GameFactory.crearMazo());
    // Act
    jugador.repartirMano();
    // Assert
    assertEquals(10, jugador.cantidadCartasEnMano());
  }

}
