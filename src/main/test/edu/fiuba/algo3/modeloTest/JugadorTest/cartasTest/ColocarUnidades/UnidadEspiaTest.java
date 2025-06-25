package edu.fiuba.algo3.modeloTest.JugadorTest.cartasTest.ColocarUnidades;

import edu.fiuba.algo3.modelo.cartas.unidades.Espia;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.jugador.atril.*;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnidadEspiaTest {
  private Jugador jugador;
  private Mano mano;
  private Mazo mazo;
  private Atril atril;
  private Jugador jugador2;

  @BeforeEach
  void setUp() {
    mano = new Mano();
    mazo = new Mazo();
    atril = new Atril();

    jugador = new Jugador(mazo, mano, atril);
    jugador2 = new Jugador(new Mazo(), new Mano(), new Atril());

  }

  @Test
  public void unaUnidadEspiaSePuedeColocarEnUnaSeccionDiferenteALasDelJugadorYRoba2CartasDelMazo() {
    // Arrange
    Seccion seccionCuerpoAcuerpo = new Seccion(new CuerpoACuerpo());

    UnidadBasica unidadParaRobar1 = new UnidadBasica(
        "robo1",
        new Puntaje(0),
        new CuerpoACuerpo());
    UnidadBasica unidadParaRobar2 = new UnidadBasica(
        "robo2",
        new Puntaje(0),
        new CuerpoACuerpo());

    Espia jamesBond = new Espia(
        "007",
        new Puntaje(6),
        new CuerpoACuerpo());

    mano.agregarCarta(jamesBond);
    mazo.agregarCarta(List.of(unidadParaRobar1, unidadParaRobar2));

    // Act
    int cantidadDeCartasEnLaManoInicial = mano.getCantidadCartas();
    int cantidadDeCartasEnElMazoInicial = mazo.getCantidadCartas();

    jugador.jugarCarta(jamesBond, jugador2, jamesBond.getTipo().get(0));

    int cantidadDeCartasEnLaManoFinal = mano.getCantidadCartas();
    int cantidadDeCartasEnElMazoFinal = mazo.getCantidadCartas();

    // Assert
    assertEquals(1, cantidadDeCartasEnLaManoInicial);
    assertEquals(2, cantidadDeCartasEnElMazoInicial);

    assertEquals(1, seccionCuerpoAcuerpo.getUnidadesColocadas().size());
    assertTrue(seccionCuerpoAcuerpo.getUnidadesColocadas().contains(jamesBond));

    assertEquals(2, cantidadDeCartasEnLaManoFinal);
    assertEquals(0, cantidadDeCartasEnElMazoFinal);
  }

  @Test
  public void unaUnidadEspiaNOSePuedeColocarEnUnaSeccionQuePerteneceAlJugador() {
    // Arrange
    Seccion seccionCuerpoAcuerpoJ1 = new Seccion(new CuerpoACuerpo());
    atril.agregarSeccion(seccionCuerpoAcuerpoJ1);

    Espia jamesBond = new Espia(
        "007",
        new Puntaje(6),
        new CuerpoACuerpo());
    mano.agregarCarta(jamesBond);

    // Act
    // Assert
    assertThrows(UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion.class, () -> {
      jugador.jugarCarta(jamesBond, jugador2, jamesBond.getTipo().get(0));
    });
  }
}
