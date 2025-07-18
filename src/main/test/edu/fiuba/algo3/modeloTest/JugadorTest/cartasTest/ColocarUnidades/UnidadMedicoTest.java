package edu.fiuba.algo3.modeloTest.JugadorTest.cartasTest.ColocarUnidades;

import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.cartas.unidades.Medico;

import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.jugador.atril.*;
import edu.fiuba.algo3.modelo.posiciones.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnidadMedicoTest {

  private Jugador jugador;
  private Mano mano;
  private Mazo mazo;
  private Atril atril;
  private Seccion seccionCuerpoACuerpoJ1;
  private Seccion seccionDistanciaJ1;

  @BeforeEach
  void setUp() {
    mano = new Mano();
    mazo = new Mazo();

    atril = new Atril();
    seccionCuerpoACuerpoJ1 = new Seccion(new CuerpoACuerpo());
    seccionDistanciaJ1 = new Seccion(new Distancia());

    jugador = new Jugador(mazo, mano, atril);
  }

  /*@Test
  public void alJugarseUnMedicoSeColocanEnElJuegoElMedicoYLaUnidadSeteadaParaRevivir() {

    // Arrange
    atril.agregarSeccion(seccionCuerpoACuerpoJ1);
    atril.agregarSeccion(seccionDistanciaJ1);

    Medico medico = new Medico(
        "DrHouse",
        new Puntaje(5),
        new Distancia());
    mano.agregarCarta(medico);

    UnidadBasica unidadBasica = new UnidadBasica(
        "Pepe",
        new Puntaje(4),
        new CuerpoACuerpo());

    medico.setUnidadParaRevivir(unidadBasica, unidadBasica.getTipo().get(0));

    // Act

    jugador.jugarCarta(medico, null, medico.getTipo().get(0));

    // Assert

    assertEquals(1, seccionCuerpoACuerpoJ1.getUnidadesColocadas().size());
    assertEquals(1, seccionDistanciaJ1.getUnidadesColocadas().size());
    assertTrue(seccionCuerpoACuerpoJ1.getUnidadesColocadas().contains(unidadBasica));
    assertTrue(seccionDistanciaJ1.getUnidadesColocadas().contains(medico));
  }*/

  @Test
  public void alJugarseUnMedicoSinUnaCartaSeteadaParaRevivirSoloSeJuegaElMedico() {

    // Arrange
    atril.agregarSeccion(seccionCuerpoACuerpoJ1);
    atril.agregarSeccion(seccionDistanciaJ1);

    Medico medico = new Medico(
        "DrHouse",
        new Puntaje(5),
        new Distancia());
    mano.agregarCarta(medico);

    // Act

    jugador.jugarCarta(medico, null, medico.getTipo().get(0));

    // Assert

    assertEquals(0, seccionCuerpoACuerpoJ1.getUnidadesColocadas().size());
    assertEquals(1, seccionDistanciaJ1.getUnidadesColocadas().size());
    assertTrue(seccionCuerpoACuerpoJ1.getUnidadesColocadas().isEmpty());
    assertTrue(seccionDistanciaJ1.getUnidadesColocadas().contains(medico));
  }
}
