package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.clases.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import edu.fiuba.algo3.auxiliares.FabricarCartas;
import edu.fiuba.algo3.clases.Carta;
import edu.fiuba.algo3.clases.Unidad;


public class JugadorTest {

  @Test
  public void jugadorMazoTest() {
    Mazo mazoJugador1 = new Mazo(FabricarCartas.crearCartasDePrueba());
    Mazo mazoJugador2 = new Mazo(FabricarCartas.crearCartasDePrueba());

    Jugador jugador1 = new Jugador("Jugador1",mazoJugador1);
    Jugador jugador2 = new Jugador("Jugador2",mazoJugador2);

    Juego juego = new Juego(jugador1, jugador2);

    assertEquals(21, jugador1.getMazo().getCantCartas());
    System.out.println("(Test01) Hay suficientes cartas("+jugador1.getMazo().getCantCartas()+") en el mazo para comenzar");
  }

  @Test
  public void jugadorManoTest() {

    Mazo mazoJugador1 = new Mazo(FabricarCartas.crearCartasDePrueba());
    Mazo mazoJugador2 = new Mazo(FabricarCartas.crearCartasDePrueba());

    Jugador jugador1 = new Jugador("Jugador1",mazoJugador1);
    Jugador jugador2 = new Jugador("Jugador2",mazoJugador2);

    Juego juego = new Juego(jugador1, jugador2);
    juego.repartirCartas();

    assertEquals(10, jugador1.getMano().getCantCartas());
    System.out.println("(Test02) Se le reparten " +jugador1.getMano().getCantCartas()+ " cartas de su mazo al jugador");
  }

  @Test
  public void jugadorPuedeColocarUnaCartaEnUnaSeccion() {
    Mazo mazoJugador1 = new Mazo(FabricarCartas.crearCartasDePrueba());
    Mazo mazoJugador2 = new Mazo(FabricarCartas.crearCartasDePrueba());

    Jugador jugador1 = new Jugador("Jugador1",mazoJugador1);
    Jugador jugador2 = new Jugador("Jugador2",mazoJugador2);

    Juego juego = new Juego(jugador1, jugador2);
    juego.repartirCartas();

    Carta cartaAColocar = jugador1.getMano().getCarta(2);
    juego.jugarCarta(jugador1,cartaAColocar);

    assertEquals(1, juego.cantidadCartasEnSeccion(jugador1,cartaAColocar));
    System.out.println("(Test03) Se colocó una carta en una sección del tablero y ahora hay:"+juego.cantidadCartasEnSeccion(jugador1,cartaAColocar)+"cartas");
  }

  @Test
  public void jugadorJuegaUnaCartaYObtienePuntaje(){
    Mazo mazoJugador1 = new Mazo(FabricarCartas.crearCartasDePrueba());
    Mazo mazoJugador2 = new Mazo(FabricarCartas.crearCartasDePrueba());

    Jugador jugador1 = new Jugador("Jugador1",mazoJugador1);
    Jugador jugador2 = new Jugador("Jugador2",mazoJugador2);

    Juego juego = new Juego(jugador1, jugador2);
    juego.repartirCartas();

    Carta cartaAColocar = jugador1.getMano().getCarta(2);
    juego.jugarCarta(jugador1,cartaAColocar);

    int puntosJugador = juego.calcularPuntaje(0);
    int puntosCartaJugada = cartaAColocar.getValorAtaque();

    System.out.println("(Test04) Se jugó la carta con "+ puntosCartaJugada + " puntos, y los puntos del jugador son " + puntosJugador);
    assertEquals(puntosCartaJugada, puntosJugador);
  }
}

