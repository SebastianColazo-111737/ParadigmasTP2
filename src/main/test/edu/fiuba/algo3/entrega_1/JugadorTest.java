package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import edu.fiuba.algo3.aux.*;
import edu.fiuba.algo3.aux.Modificadores.Unidas;

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
  private Especial cartaMock14;
  private Unidad cartaMock15;
  private Unidad cartaMock16;
  private Unidad cartaMock17;
  private Unidad cartaMock18;
  private Unidad cartaMock19;
  private Unidad cartaMock20;
  private Unidad cartaMock21;

  @BeforeEach
  public void setup() {
    this.cartaMock1 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock2 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
    this.cartaMock3 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock4 = new Unidad("Medico", 2, Posicion.ASEDIO, null);
    this.cartaMock5 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock6 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
    this.cartaMock7 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock8 = new Unidad("Catapulta", 8, Posicion.ASEDIO, null);
    this.cartaMock9 = new Unidad("Asesino", 10, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock10 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
    this.cartaMock11 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock12 = new Unidad("Catapulta", 8, Posicion.ASEDIO, new Unidas());
    this.cartaMock13 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock14 = new Nieve("Nieve", zonaEspeciales);
    this.cartaMock15 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock16 = new Unidad("Medico", 2, Posicion.ASEDIO, null);
    this.cartaMock17 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
    this.cartaMock18 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
    this.cartaMock19 = new Unidad("Catapulta", 8, Posicion.ASEDIO, new Unidas());
    this.cartaMock20 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
    this.cartaMock21 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);

    this.cartasMock1 = new ArrayList<>(Arrays.asList(
        cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
        cartaMock6, cartaMock7, cartaMock8, cartaMock9, cartaMock10,
        cartaMock11, cartaMock12, cartaMock13, cartaMock14, cartaMock15,
        cartaMock16, cartaMock17, cartaMock18, cartaMock19, cartaMock20, cartaMock21));

    this.cartasMock2 = new ArrayList<>();
    for (Carta carta : this.cartasMock1) {
      if (carta instanceof Unidad) {
        Unidad unidad = (Unidad) carta;
        cartasMock2.add(new Unidad(unidad.getName(), unidad.obtenerPuntosBase(), unidad.getPosicion(), null));
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
    assertEquals(21, jugador.cartasEnElMazo());
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
    Tablero tablero = new Tablero(jugador1, jugador2);

    // Act
    Carta cartaAColocar = jugador1.getMano().getCarta(2);
    jugador1.jugarCarta(cartaAColocar, tablero, Posicion.ASEDIO);

    // Assert
    assertEquals(1, tablero.getCantidadCartasEnSeccion(jugador1, Posicion.ASEDIO));
  }

  @Test
  public void jugadorJuegaUnaCartaYObtienePuntaje() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Tablero tablero = new Tablero(jugador1, jugador2);
    jugador1.repartirMano();

    // Act

    Unidad cartaAColocar = (Unidad) jugador1.obtenerCartaEnMano(8);
    jugador1.jugarCarta(cartaAColocar, tablero, Posicion.CUERPO_A_CUERPO);

    // Assert
    assertEquals(cartaAColocar.obtenerPuntosBase(), tablero.getPuntajeEnSeccion(jugador1, Posicion.CUERPO_A_CUERPO));
  }

  @Test
  public void lasCartasPasanALaPilaDeDescarte() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    jugador1.repartirMano();

    Carta cartaADescartar = jugador1.getMano().getCarta(0);

    // Act
    jugador1.descartarCarta(cartaADescartar);

    // Assert
    assertEquals(1, jugador1.getDescarte().getCantCartasEnPila());
  }

  @Test
  public void seUnenDosCartasYSeCambianLosPuntos() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);
    juego.repartirCartas();

    Unidad primeraCatapulta = (Unidad) jugador1.obtenerCartaEnMano(9);
    Unidad segundaCatapulta = (Unidad) jugador2.obtenerCartaEnMano(2);
    Unidad terceraCataPulta = (Unidad) jugador1.obtenerCartaEnMano(2);
    // Act
    juego.jugarCarta(jugador1, primeraCatapulta, Posicion.ASEDIO);
    juego.jugarCarta(jugador1, terceraCataPulta, Posicion.ASEDIO);
    juego.jugarCarta(jugador2, segundaCatapulta, Posicion.ASEDIO);
    // Assert
    // assertEquals(2, juego.cantidadCartasEnSeccion(jugador1, Posicion.ASEDIO));
    assertEquals(16, primeraCatapulta.getPuntosModificados()); // Dos catapultas:
    // 8*2 = 16

  }

  @Test
  //Nieve: Pone a las cartas CuerpoACuerpo con puntaje 1
  public void seUsaUnaCartaClimaYSeReducenLosValoresDeLasUnidadesEnLaSeccion(){
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));


    Juego juego = new Juego(jugador2, jugador1);
    ZonaEspeciales zonaEspeciales = new ZonaEspeciales();

    jugador1.repartirMano();
    jugador2.repartirMano();

    Unidad primeraCartaJugador2 = (Unidad) jugador2.obtenerCartaEnMano(3);
    Especial primeraCartaJugador1 = (Especial) jugador1.obtenerCartaEnMano(7);

    // Act
    juego.jugarCarta(jugador2, primeraCartaJugador2, Posicion.CUERPO_A_CUERPO);
    juego.jugarCartaEspecial(jugador1,primeraCartaJugador1,zonaEspeciales);

    // Assert
    assertEquals(1,primeraCartaJugador2.getPuntosModificados());
  }
}
