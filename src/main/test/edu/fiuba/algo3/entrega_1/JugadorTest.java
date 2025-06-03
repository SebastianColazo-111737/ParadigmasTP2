package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.clases.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JugadorTest {

  @Test
  public void jugadorMazoTest() {
    Juego juego = new Juego("player1", "player2");
    assertEquals(21, juego.cartasEnElMazoJugador(0));
    System.out.println("(Test01) Hay suficientes cartas("+juego.cartasEnElMazoJugador(0)+") en el mazo para comenzar");
  }

  @Test
  public void jugadorManoTest() {
    Juego juego = new Juego("player1", "player2");
    juego.repartirCartasDelMazoJugador(0);
    assertEquals(10, juego.cartasEnManoJugador(0));
    System.out.println("(Test02) Se le reparten " +juego.cartasEnManoJugador(0)+ " cartas de su mazo al jugador");
  }

  @Test
  public void jugadorPuedeColocarUnaCartaEnUnaSeccion() {
    Juego juego = new Juego("player1", "player2");
    juego.repartirCartasDelMazoJugador(0);
    juego.colocarCarta(0, 2, 0);
    assertEquals(1, juego.cantidadCartasEnSeccion(0));
    System.out.println("(Test03) Se colocó una carta en una sección del tablero y ahora hay:"+juego.cantidadCartasEnSeccion(0)+"cartas");
  }

  @Test
  public void jugadorJuegaUnaCartaYObtienePuntaje(){
    Juego juego = new Juego("player1","player2");
    juego.repartirCartasDelMazoJugador(0);

    Carta cartaJugada = juego.obtenerCartaEnMano(0,2);
    int puntosCartaJugada = ((Unidad) cartaJugada).obtenerPuntosBase();

    juego.colocarCarta(0,2,0);

    int puntosJugador = juego.obtenerPuntajeActualJugador(0);

    System.out.println("(Test04) Se jugó la carta con "+ puntosCartaJugada + " puntos, y los puntos del jugador son " + puntosJugador);

    assertEquals(puntosCartaJugada, puntosJugador);
  }


}

