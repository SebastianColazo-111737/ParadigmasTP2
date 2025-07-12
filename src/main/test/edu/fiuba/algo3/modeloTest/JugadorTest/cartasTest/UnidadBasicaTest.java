package edu.fiuba.algo3.modeloTest.JugadorTest.cartasTest;

import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.jugador.atril.*;

import edu.fiuba.algo3.modelo.posiciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnidadBasicaTest {

  private Jugador jugador;
  private Mano mano;
  private Mazo mazo;
  private Atril atril;

  @BeforeEach
  void setUp() {
    mano = new Mano();
    mazo = new Mazo();
    atril = new Atril();

    jugador = new Jugador(mazo, mano, atril);
  }

  @Test
  public void unJugadorPuedeColocarUnaUnidadBasicaQueEstaEnSuManoEnUnaSeccionQueEstaEnSuAtril() {

    // Arrange
    Seccion seccionDistanciaJ1 = new Seccion(new Distancia());
    atril.agregarSeccion(seccionDistanciaJ1);

    UnidadBasica unidadBasica = new UnidadBasica(
        "Unidad",
        new Puntaje(0),
        new Distancia());
    mano.agregarCarta(unidadBasica);

    // Act
    int cantidadDeCartasEnSeccionInicial = seccionDistanciaJ1.getUnidadesColocadas().size();
    jugador.jugarCarta(unidadBasica, null, unidadBasica.getTipo().get(0));
    int cantidadDeCartasEnSeccionFInal = seccionDistanciaJ1.getUnidadesColocadas().size();

    // Assert
    assertEquals(0, cantidadDeCartasEnSeccionInicial);
    assertEquals(1, cantidadDeCartasEnSeccionFInal);
    assertTrue(seccionDistanciaJ1.getUnidadesColocadas().contains(unidadBasica));
  }

  @Test
  public void unJugadorNOPuedeColocarUnaUnidadBasicaQueNOEstaEnSuMano() {

    // Arrange
    Seccion seccionDistanciaJ1 = new Seccion(new Distancia());
    atril.agregarSeccion(seccionDistanciaJ1);

    UnidadBasica unidadBasica = new UnidadBasica(
        "Unidad",
        new Puntaje(0),
        new Distancia());
    // Act

    // Assert
    assertFalse(mano.getCartas().contains(unidadBasica));
    assertThrows(ManoNoContieneCartaException.class, () -> {
      jugador.jugarCarta(unidadBasica, null, unidadBasica.getTipo().get(0));
    });
  }

}
