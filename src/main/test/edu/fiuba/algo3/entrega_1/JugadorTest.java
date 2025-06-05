package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import edu.fiuba.algo3.clases.*;

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

  @BeforeEach
  public void setup() {
    this.cartaMock1 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO);
    this.cartaMock2 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock3 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock4 = new Unidad("Medico", 2, Posicion.ASEDIO);
    this.cartaMock5 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO);
    this.cartaMock6 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock7 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock8 = new Unidad("Catapulta", 8, Posicion.ASEDIO);
    this.cartaMock9 = new Unidad("Asesino", 10, Posicion.CUERPO_A_CUERPO);
    this.cartaMock10 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock11 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock12 = new Unidad("Catapulta", 8, Posicion.ASEDIO);
    this.cartaMock13 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO);
    this.cartaMock14 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock15 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock16 = new Unidad("Medico", 2, Posicion.ASEDIO);
    this.cartaMock17 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA);
    this.cartaMock18 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO);
    this.cartaMock19 = new Unidad("Catapulta", 8, Posicion.ASEDIO);
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
    jugador1.repartirMano();
    Tablero tablero = new Tablero(jugador1, jugador2);

    // Act
    Carta cartaAColocar = jugador1.getMano().getCarta(2);
    jugador1.jugarCarta((Unidad) cartaAColocar, tablero, Posicion.ASEDIO);

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

    Carta cartaAColocar = jugador1.obtenerCartaEnMano(8);
    jugador1.jugarCarta((Unidad) cartaAColocar, tablero, Posicion.CUERPO_A_CUERPO);

    // Assert
    assertEquals(cartaAColocar.getValorAtaque(), tablero.getPuntajeEnSeccion(jugador1, Posicion.CUERPO_A_CUERPO));
  }

  @Test
  public void lasCartasPasanALaPilaDeDescarte(){
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Tablero tablero = new Tablero(jugador1, jugador2);
    jugador1.repartirMano();

    Carta cartaADescartar = jugador1.getMano().getCarta(0);

    // Act
    jugador1.descartarCarta(cartaADescartar);

    //Assert
    assertEquals(1, jugador1.getDescarte().getCantCartasEnPila());
  }

  @Test
  public void seUnenDosCartasYSeCambianLosPuntos(){
    // Arrange
    Jugador jugador1 = new Jugador("Jugador1", new Mazo(this.cartasMock1));
    Jugador jugador2 = new Jugador("Jugador2", new Mazo(this.cartasMock2));
    Juego juego = new Juego(jugador1, jugador2);
    juego.repartirCartas();

    Unidad primeraCatapulta = (Unidad) jugador1.obtenerCartaEnMano(9);
    Unidad segundaCatapulta = (Unidad) jugador1.obtenerCartaEnMano(2);

    // Act
    juego.jugarCarta(jugador1,primeraCatapulta,Posicion.ASEDIO);
    juego.jugarCarta(jugador2,segundaCatapulta,Posicion.ASEDIO);

    // Assert
    assertEquals(16, primeraCatapulta.getValorAtaque()); //Dos catapultas: 8*2 = 16

    // Act
    juego.getTablero().vaciarTablero();

    //Assert
    assertEquals(8, primeraCatapulta.getValorAtaque());
  }
}
