
package edu.fiuba.algo3.modeloTest.JugadorTest.cartasTest.Especiales;

import edu.fiuba.algo3.modelo.juego.AdminTurnos;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.cartas.especiales.BuffCartas;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.cartas.especiales.DeBuffCleaner;
import edu.fiuba.algo3.modelo.cartas.especiales.Debuff;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.jugador.atril.*;

import edu.fiuba.algo3.modelo.posiciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class CleanerTest {

  private Jugador jugador;
  private Jugador jugador2;
  private Mano mano2;
  private Mazo mazo2;
  private Atril atril2;
  private Mano mano;
  private Mazo mazo;
  private Atril atril;

  private Seccion cuerpo1;
  private Seccion cuerpo2;

  private Seccion distancia1;
  private Seccion distancia2;

  private Seccion asedio1;
  private Seccion asedio2;

  @BeforeEach
  void setUp() {
    mano = new Mano();
    mazo = new Mazo();
    atril = new Atril();
    mano2 = new Mano();
    mazo2 = new Mazo();
    atril2 = new Atril();

    cuerpo1 = new Seccion(new CuerpoACuerpo());
    cuerpo2 = new Seccion(new CuerpoACuerpo());

    distancia1 = new Seccion(new Distancia());
    distancia2 = new Seccion(new Distancia());

    asedio1 = new Seccion(new Asedio());
    asedio2 = new Seccion(new Asedio());

    atril.agregarSeccion(cuerpo1);
    atril.agregarSeccion(distancia1);
    atril.agregarSeccion(asedio1);

    atril2.agregarSeccion(cuerpo2);
    atril2.agregarSeccion(distancia2);
    atril2.agregarSeccion(asedio2);

    jugador = new Jugador(mazo, mano, atril,"NombreDePrueba");
    jugador2 = new Jugador(mazo2, mano2, atril2,"NombreDePrueba2");
  }

  @Test
  public void UnTiempoSoleadoLimpiaAlMenosUnClima() {

    // Arrange
    ArrayList<Posicion> posicionesAfectar = new ArrayList<>();
    posicionesAfectar.add(new Distancia());
    CEspecial nieve = new Debuff("Nieve", posicionesAfectar,"Descripcion");
    CEspecial limpiadorClimas = new DeBuffCleaner("Soleado", posicionesAfectar,"Descripcion");
    UnidadBasica unidad1 = new UnidadBasica(
        "Unidad",
        new Puntaje(3),
        new Distancia());
    UnidadBasica unidad2 = new UnidadBasica(
        "Unidad",
        new Puntaje(3),
        new Distancia());

    UnidadBasica unidad3 = new UnidadBasica(
        "Unidad",
        new Puntaje(3),
        new Distancia());

    UnidadBasica unidad4 = new UnidadBasica(
        "Unidad",
        new Puntaje(3),
        new Asedio());

    mano.agregarCarta(unidad1);
    mano.agregarCarta(unidad2);
    mano.agregarCarta(unidad3);
    mano.agregarCarta(unidad4);
    mano.agregarCarta(nieve);
    mano.agregarCarta(limpiadorClimas);

    // Act
    jugador.jugarCarta(unidad1, jugador2, unidad1.getTipo().get(0),mockTurnos);
    jugador.jugarCarta(unidad2, jugador2, unidad1.getTipo().get(0),mockTurnos);
    jugador.jugarCarta(unidad3, jugador2, unidad1.getTipo().get(0),mockTurnos);
    jugador.jugarCarta(unidad4, jugador2, unidad4.getTipo().get(0),mockTurnos);
    jugador.jugarCarta(nieve, jugador2, null,mockTurnos);
    jugador.jugarCarta(limpiadorClimas, jugador2, null,mockTurnos);

    // Assert
    assertEquals(12, atril.getPuntajeActual());
  }
  AdminTurnos mockTurnos = Mockito.mock(AdminTurnos.class);

}
