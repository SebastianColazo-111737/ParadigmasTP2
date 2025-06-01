package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.falopa.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

  @Test
  public void jugadorMazoTest() {
    Juego juego = new Juego("player1", "player2");
    assertEquals(21, juego.cartasEnElMazoJugador(0));
  }

  @Test
  public void jugadoManoTest() {
    Juego juego = new Juego("player1", "player2");
    juego.repartirCartasDelMazoJugador(0);
    assertEquals(10, juego.cartasEnManoJugador(0));
  }

}
