package edu.fiuba.algo3.aux;

import java.util.List;
import java.util.ArrayList;

public class Juego {
  private List<Jugador> jugadores;
  private Tablero tablero;
  private AdminTurnos adminTurnos;


  public Juego(Jugador jugador1, Jugador jugador2) {

    this.jugadores = new ArrayList<>();
    jugadores.add(jugador1);
    jugadores.add(jugador2);
    this.adminTurnos = new AdminTurnos();
    this.tablero = new Tablero(jugador1, jugador2);
  }

  public int cantidadCartasEnSeccion(Jugador jugador, Posicion posicion) {
    return tablero.getCantidadCartasEnSeccion(jugador, posicion);
  }

  public Boolean jugarCarta(Jugador jugador, Carta carta, Posicion posicion) {
    if (jugador == getJugadorTurnoActual() && jugador.jugarCarta(carta, this.tablero, posicion)) {
      System.out.println("Jugo la carta correctamente");
      this.adminTurnos.siguienteTurno();
      return true;
    }
    return false;
  }

  public Boolean jugarCartaEspecial(Jugador jugador, Especial carta, ZonaEspeciales zonaEspeciales){
    if(jugador == getJugadorTurnoActual() && jugador.jugarCartaEspecial(carta, this.tablero, zonaEspeciales)){
      this.adminTurnos.siguienteTurno();
      return true;
    }
    return false;
  }

  public void repartirCartas() {
    for (Jugador jugador : jugadores) {
      jugador.robarCartas(10);
    }
  }

  public Jugador getJugadorTurnoActual() {
    return this.jugadores.get(this.adminTurnos.getIndiceJugadorActual());
  }

  public Jugador getJugadorSiguienteTurno() {
    return this.jugadores.get(this.adminTurnos.getIndiceJugadorSiguiente());
  }
}
