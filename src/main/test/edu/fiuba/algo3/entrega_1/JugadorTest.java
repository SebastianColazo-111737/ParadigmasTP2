package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.Modificadores.Espia;
import edu.fiuba.algo3.clases.Modificadores.Medico;
import edu.fiuba.algo3.clases.Modificadores.SumaBase;
import edu.fiuba.algo3.clases.Tipos.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Modificadores.Unidas;

public class JugadorTest {

  @Mock
  private Mazo mazoMock;

  @Mock
  private ArrayList<Carta> cartasMock1;

  @Mock
  private ArrayList<Carta> cartasMock2;

  @Mock
  private ZonaEspeciales zonaEspeciales;

  private Unidad cartaMock1;
  private Unidad cartaMock2;
  private Unidad cartaMock3;
  private Unidad cartaMock4;
  private Unidad cartaMock5;
  private Unidad cartaMock6;
  private Unidad cartaMock7;
  private Unidad cartaMock8;
  private Unidad cartaMock9;
  private Unidad cartaMock10;
  private Unidad cartaMock11;
  private Unidad cartaMock12;
  private Unidad cartaMock13;
  // private Especial cartaMock14;
  private Unidad cartaMock15;
  private Unidad cartaMock16;
  private Unidad cartaMock17;
  private Unidad cartaMock18;
  private Unidad cartaMock19;
  private Unidad cartaMock20;
  private Unidad cartaMock21;

  @BeforeEach
  public void setup() {
    ArrayList<Tipo> cuerpo = new ArrayList<>();
    ArrayList<Tipo> distancia = new ArrayList<>();
    ArrayList<Tipo> asedio = new ArrayList<>();
    cuerpo.add(new CuerpoACuerpo());
    distancia.add(new Distancia());
    asedio.add(new Asedio());
    this.cartaMock1 = new Unidad("Asesino", 8, cuerpo, null, false);
    this.cartaMock2 = new Unidad("Arquero", 4, distancia, null, false);
    this.cartaMock3 = new Unidad("Guerrero", 6, cuerpo, null, false);
    this.cartaMock4 = new Unidad("Medico", 2, asedio, null, false);
    this.cartaMock5 = new Unidad("Asesino", 8, cuerpo, null, false);
    this.cartaMock6 = new Unidad("Arquero", 4, distancia, null, false);
    this.cartaMock7 = new Unidad("Guerrero", 6, cuerpo, null, false);
    this.cartaMock8 = new Unidad("Catapulta", 8, asedio, null, false);
    this.cartaMock9 = new Unidad("Asesino", 10, cuerpo, null, false);
    this.cartaMock10 = new Unidad("Arquero", 4, distancia, null, false);
    this.cartaMock11 = new Unidad("Guerrero", 6, cuerpo, null, false);
    this.cartaMock12 = new Unidad("Catapulta", 8, asedio, null, false);
    this.cartaMock13 = new Unidad("Asesino", 8, cuerpo, null, false);
    // this.cartaMock14 = new Nieve("Nieve", zonaEspeciales);
    this.cartaMock15 = new Unidad("Guerrero", 6, cuerpo, null, false);
    this.cartaMock16 = new Unidad("Medico", 2, asedio, null, false);
    this.cartaMock17 = new Unidad("Arquero", 4, distancia, null, false);
    this.cartaMock18 = new Unidad("Guerrero", 6, cuerpo, null, false);
    this.cartaMock19 = new Unidad("Catapulta", 8, asedio, null, false);
    this.cartaMock20 = new Unidad("Arquero", 4, distancia, null, false);
    this.cartaMock21 = new Unidad("Medico", 2, asedio, new Medico(), false);

    this.cartasMock1 = new ArrayList<>(Arrays.asList(
        cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
        cartaMock6, cartaMock7, cartaMock8, cartaMock9, cartaMock10,
        // cartaMock11, cartaMock12, cartaMock13, cartaMock14, cartaMock15,
        cartaMock16, cartaMock17, cartaMock18, cartaMock19, cartaMock20, cartaMock21));

    this.cartasMock2 = new ArrayList<>();
    for (Carta carta : this.cartasMock1) {
      if (carta instanceof Unidad) {
        Unidad unidad = (Unidad) carta;
        cartasMock2.add(new Unidad(unidad.getName(), unidad.obtenerPuntosBase(), unidad.getTipo(), null, false));
      }
    }
  }

  @Test
  public void jugadorMazoTest() {

    // Arrange
    Mazo mazo = new Mazo(this.cartasMock1);

    // Act
    Jugador jugador = new Jugador("Player1", mazo);

    // Assert
    assertEquals(16, jugador.cartasEnElMazo());
  }

  @Test
  public void jugadorManoTest() {

    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));

    // Act
    jugador1.repartirMano();

    // Assert
    assertEquals(10, jugador1.cantidadCartasEnMano());
  }

  @Test
  public void jugadorPuedeColocarUnaCartaEnUnaSeccion() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    jugador1.repartirMano();

    // Act
    Carta cartaAColocar = jugador1.getMano().get(2);
    jugador1.jugar(cartaAColocar, cartaAColocar.getTipo().get(0), jugador2);

    // Assert
    assertEquals(1, jugador1.getCantidadCartasEnSeccion(cartaAColocar.getTipo().get(0)));
  }

  @Test
  public void jugadorJuegaUnaCartaYObtienePuntaje() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    jugador1.repartirMano();

    // Act

    Carta carta = jugador1.getMano().get(8);

    jugador1.jugar(carta, carta.getTipo().get(0), jugador2);

    // Assert
    assertEquals(8,
        jugador1.getPuntajeEnSeccion(carta.getTipo().get(0)));
  }

  @Test
  public void lasCartasPasanALaPilaDeDescarte() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    jugador1.repartirMano();

    Carta cartaADescartar = jugador1.getMano().get(0);

    // Act
    jugador1.descartarCarta(cartaADescartar);

    // Assert
    assertEquals(1, jugador1.getDescarte().size());
  }

  @Test
  public void seUnenDosCartasYSeCambianLosPuntos() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);

    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());
    Unidad primeraCatapulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad segundaCatapulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad terceraCataPulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    mano1.add(primeraCatapulta);
    mano1.add(terceraCataPulta);
    mano2.add(segundaCatapulta);
    // Act
    juego.jugar(jugador1, primeraCatapulta, primeraCatapulta.getTipo().get(0));
    juego.jugar(jugador2, segundaCatapulta, segundaCatapulta.getTipo().get(0));
    juego.jugar(jugador1, terceraCataPulta, terceraCataPulta.getTipo().get(0));
    // Assert

    assertEquals(16, primeraCatapulta.getPuntosModificados()); // dos catapultas:
    // 8*2 = 16

  }

  @Test
  public void testAlLimpiarNoQuedanCartas() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);
    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());
    Unidad primeraCatapulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad segundaCatapulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad terceraCataPulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    mano1.add(primeraCatapulta);
    mano1.add(terceraCataPulta);
    mano2.add(segundaCatapulta);
    // Act
    juego.jugar(jugador1, primeraCatapulta, primeraCatapulta.getTipo().get(0));
    juego.jugar(jugador2, segundaCatapulta, segundaCatapulta.getTipo().get(0));
    juego.jugar(jugador1, terceraCataPulta, terceraCataPulta.getTipo().get(0));
    juego.limpiarTablero();

    // Assert
    assertEquals(0, jugador1.getCantidadCartasEnSeccion(primeraCatapulta.getTipo().get(0)));
  }

  @Test
  public void testLaCartaVaAlDescarteAlLimpiarTablero() {

    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);
    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());
    Unidad primeraCatapulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad segundaCatapulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad terceraCataPulta = new Unidad("Catapulta", 8, tipo, new Unidas(), false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    mano1.add(primeraCatapulta);
    mano1.add(terceraCataPulta);
    mano2.add(segundaCatapulta);

    juego.jugar(jugador1, primeraCatapulta, primeraCatapulta.getTipo().get(0));
    juego.jugar(jugador2, segundaCatapulta, segundaCatapulta.getTipo().get(0));

    juego.limpiarTablero();

    assertEquals(1, jugador1.cantidadCartasEnDescarte());

  }

  @Test
  public void testSumaBase() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);
    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());
    Unidad cartaSumaBase = new Unidad("CartaAsedioTest", 8, tipo, new SumaBase(), false);
    Unidad carta1 = new Unidad("Catapulta", 8, tipo, null, false);
    Unidad carta2 = new Unidad("Catapulta", 8, tipo, null, false);
    Unidad carta3 = new Unidad("Catapulta", 8, tipo, null, false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    mano1.add(cartaSumaBase);
    mano1.add(carta1);
    mano2.add(carta2);
    mano2.add(carta3);

    juego.jugar(jugador1, carta1, carta1.getTipo().get(0));
    juego.jugar(jugador2, carta2, carta2.getTipo().get(0));
    juego.jugar(jugador1, cartaSumaBase, cartaSumaBase.getTipo().get(0));
    juego.jugar(jugador2, carta3, carta3.getTipo().get(0));

    assertEquals(17, jugador1.getPuntajeEnSeccion(cartaSumaBase.getTipo().get(0)));

  }

  @Test
  public void testMedico() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);

    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());
    Unidad medico = new Unidad("Médico", 2, tipo, new Medico(), false);
    Unidad carta1 = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad carta2 = new Unidad("Catapulta", 8, tipo, new Unidas(), false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    mano1.add(medico);
    mano1.add(carta1);
    mano2.add(carta2);

    juego.jugar(jugador1, carta1, carta1.getTipo().get(0));
    juego.jugar(jugador2, carta2, carta2.getTipo().get(0));

    juego.limpiarTablero();

    Carta revivir = jugador1.getDescarte().get(0);
    Medico modificador = (Medico) medico.getModificador();

    modificador.setCartaRevivir(revivir, revivir.getTipo().get(0));

    juego.jugar(jugador1, medico, medico.getTipo().get(0));
    assertEquals(2, jugador1.getCantidadCartasEnSeccion(medico.getTipo().get(0)));

  }

  @Test
  public void testUsarEspiaSeColocaEnLaSeccionDelEnemigo() {
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);

    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());

    Unidad espia = new Unidad("EspiaTest", 1, tipo, new Espia(), false);
    Unidad carta1 = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad carta2 = new Unidad("Catapulta", 8, tipo, new Unidas(), false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    mano1.add(espia);
    mano1.add(carta1);
    mano2.add(carta2);

    juego.jugar(jugador1, carta1, carta1.getTipo().get(0));
    juego.jugar(jugador2, carta2, carta2.getTipo().get(0));
    juego.jugar(jugador1, espia, espia.getTipo().get(0));

    assertEquals(2, jugador2.getCantidadCartasEnSeccion(espia.getTipo().get(0)));

  }

  @Test
  public void testUsarEspiaTomaDosCartasDelMazo() {
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);

    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());
    Unidad espia = new Unidad("EspiaTest", 1, tipo, new Espia(), false);
    Unidad carta1 = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad carta2 = new Unidad("Catapulta", 8, tipo, new Unidas(), false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    int esperado = mano1.size() + 2;
    mano1.add(espia);
    mano1.add(carta1);
    mano2.add(carta2);

    juego.jugar(jugador1, carta1, carta1.getTipo().get(0));
    juego.jugar(jugador2, carta2, carta2.getTipo().get(0));
    juego.jugar(jugador1, espia, espia.getTipo().get(0));

    assertEquals(esperado, mano1.size());

  }

  @Test
  public void testAgil() {
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);

    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());
    ArrayList<Tipo> agilTipos = new ArrayList<>();
    agilTipos.add(new Distancia());
    agilTipos.add(new CuerpoACuerpo());
    Unidad agil = new Unidad("AgilGenerico####################################", 100, agilTipos, null, false);
    Unidad carta1 = new Unidad("Catapulta", 8, tipo, new Unidas(), false);
    Unidad carta2 = new Unidad("Catapulta", 8, tipo, new Unidas(), false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    mano1.add(carta1);
    mano1.add(agil);
    mano2.add(carta2);

    juego.jugar(jugador1, carta1, carta1.getTipo().get(0));
    juego.jugar(jugador2, carta2, carta2.getTipo().get(0));
    juego.jugar(jugador1, agil, agil.getTipo().get(1));

    assertEquals(1, juego.cantidadCartasEnSeccion(jugador1, agil.getTipo().get(1)));

  }

  @Test
  public void testLegendaria() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);
    ArrayList<Tipo> tipo = new ArrayList<>();
    tipo.add(new Asedio());
    Unidad cartaSumaBase = new Unidad("CartaAsedioTest", 8, tipo, new SumaBase(), false);
    Unidad carta1 = new Unidad("LegendariaGenerica", 200, tipo, null, true);
    Unidad carta2 = new Unidad("Catapulta", 8, tipo, null, false);
    Unidad carta3 = new Unidad("Catapulta", 8, tipo, null, false);

    ArrayList<Carta> mano1 = jugador1.getMano();
    ArrayList<Carta> mano2 = jugador2.getMano();

    mano1.add(cartaSumaBase);
    mano1.add(carta1);
    mano2.add(carta2);
    mano2.add(carta3);

    juego.jugar(jugador1, carta1, carta1.getTipo().get(0));
    juego.jugar(jugador2, carta2, carta2.getTipo().get(0));
    juego.jugar(jugador1, cartaSumaBase, cartaSumaBase.getTipo().get(0));
    juego.jugar(jugador2, carta3, carta3.getTipo().get(0));

    assertEquals(208, jugador1.getPuntajeEnSeccion(cartaSumaBase.getTipo().get(0)));

  }

  // @Test
  // // Nieve: Pone a las cartas CuerpoACuerpo con puntaje 1
  // public void seUsaUnaCartaClimaYSeReducenLosValoresDeLasUnidadesEnLaSeccion()
  // {
  // // Arrange
  // Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
  // Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
  //
  // Juego juego = new Juego(jugador2, jugador1);
  // ZonaEspeciales zonaEspeciales = new ZonaEspeciales();
  //
  // jugador1.repartirMano();
  // jugador2.repartirMano();
  //
  // Unidad primeraCartaJugador2 = (Unidad) jugador2.obtenerCartaEnMano(3);
  // Especial primeraCartaJugador1 = (Especial) jugador1.obtenerCartaEnMano(7);
  //
  // // Act
  // juego.jugarCarta(jugador2, primeraCartaJugador2, Posicion.CUERPO_A_CUERPO);
  // juego.jugarCartaEspecial(jugador1, primeraCartaJugador1, zonaEspeciales);
  //
  // // Assert
  // assertEquals(1, primeraCartaJugador2.getPuntosModificados());
  // }
}
