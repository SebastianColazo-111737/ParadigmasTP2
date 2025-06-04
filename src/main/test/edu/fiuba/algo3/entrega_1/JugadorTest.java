package edu.fiuba.algo3.entrega_1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import edu.fiuba.algo3.clases.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.auxiliares.FabricarCartas;

public class JugadorTest {

  @Mock
  private Mazo mazoMock;

  @Mock
  private ArrayList<Carta> cartasMock1;

  @Mock
  private ArrayList<Carta> cartasMock2;

  private Carta cartaMock1;
  private Carta cartaMock2;
  private Carta cartaMock3;
  private Carta cartaMock4;
  private Carta cartaMock5;
  private Carta cartaMock6;
  private Carta cartaMock7;
  private Carta cartaMock8;
  private Carta cartaMock9;
  private Carta cartaMock10;
  private Carta cartaMock11;
  private Carta cartaMock12;
  private Carta cartaMock13;
  private Carta cartaMock14;
  private Carta cartaMock15;
  private Carta cartaMock16;
  private Carta cartaMock17;
  private Carta cartaMock18;
  private Carta cartaMock19;
  private Carta cartaMock20;
  private Carta cartaMock21;

  @Before
  public void setup() {
    this.cartaMock1 = new Unidad("Asesino", 10, Posicion.CUERPO_A_CUERPO);
    this.cartaMock2 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock3 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock4 = new Unidad("Medico", 2, Posicion.ASEDIO);
    this.cartaMock5 = new Unidad("Asesino", 10, Posicion.CUERPO_A_CUERPO);
    this.cartaMock6 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock7 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock8 = new Unidad("Medico", 2, Posicion.ASEDIO);
    this.cartaMock9 = new Unidad("Asesino", 10, Posicion.CUERPO_A_CUERPO);
    this.cartaMock10 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock11 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock12 = new Unidad("Medico", 2, Posicion.ASEDIO);
    this.cartaMock13 = new Unidad("Asesino", 10, Posicion.CUERPO_A_CUERPO);
    this.cartaMock14 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock15 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock16 = new Unidad("Medico", 2, Posicion.ASEDIO);
    this.cartaMock17 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock18 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock19 = new Unidad("Medico", 2, Posicion.ASEDIO);
    this.cartaMock20 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock21 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);

    this.cartasMock1 = new ArrayList<>(Arrays.asList(
        cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
        cartaMock6, cartaMock7, cartaMock8, cartaMock9, cartaMock10,
        cartaMock11, cartaMock12, cartaMock13, cartaMock14, cartaMock15,
        cartaMock16, cartaMock17, cartaMock18, cartaMock19, cartaMock20, cartaMock21));

    this.cartasMock2 = new ArrayList<>();
    for (Carta carta : this.cartasMock1) {
      cartasMock2.add(new Unidad(carta.getName(), carta.getValorAtaque(), carta.getPosicion()));
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

    Juego juego = new Juego(jugador1, jugador2);
    juego.repartirCartas();

    // Act

    Carta cartaAColocar = jugador1.getMano().getCarta(2);
    juego.jugarCarta(jugador1, cartaAColocar);

    // Assert
    assertEquals(1, juego.cantidadCartasEnSeccion(jugador1, Posicion.A_DISTANCIA));
  }

  @Test
  public void jugadorJuegaUnaCartaYObtienePuntaje() {
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));

    Juego juego = new Juego(jugador1, jugador2);
    juego.repartirCartas();
    // Act
    Carta cartaAColocar = jugador1.getMano().getCarta(2);
    juego.jugarCarta(jugador1, cartaAColocar);

    int puntosJugador = juego.calcularPuntaje(0);
    int puntosCartaJugada = cartaAColocar.getValorAtaque();
    // Assert
    assertEquals(puntosCartaJugada, puntosJugador);
  }
}
