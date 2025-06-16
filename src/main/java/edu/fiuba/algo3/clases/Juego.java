package edu.fiuba.algo3.clases;

import edu.fiuba.algo3.clases.Cartas.*;
import java.util.List;
import java.util.ArrayList;

import edu.fiuba.algo3.clases.Tipos.*;

public class Juego {
  private List<Jugador> jugadores;
  private AdminTurnos adminTurnos;

  public Juego(Jugador jugador1, Jugador jugador2) {

    this.jugadores = new ArrayList<>();
    jugadores.add(jugador1);
    jugadores.add(jugador2);
    this.adminTurnos = new AdminTurnos();
  }

  public int cantidadCartasEnSeccion(Jugador jugador, Tipo posicion) {
    return jugador.getCantidadCartasEnSeccion(posicion);
  }

  public Boolean jugar(Jugador jugador, Carta carta, Tipo posicion) {
    if (jugador == getJugadorTurnoActual() && jugador.jugar(carta, posicion, this.getJugadorSiguienteTurno())) {
      this.adminTurnos.siguienteTurno();
      System.out.println(
          "Pudo jugar" + carta.getName() + " " + carta.getTipo().getClass() + " El jugador: " + jugador.getName());
      return true;
    }
    return false;
  }

  public void limpiarTablero() {
    for (Jugador jugador : this.jugadores) {
      jugador.limpiarSecciones();
    }
  }

  // Aplicar polimorfismo -> porque se usa un interfaz de Carta
  // public Boolean jugarCartaEspecial(Jugador jugador, Especial carta,
  // ZonaEspeciales zonaEspeciales) {
  // if (jugador == getJugadorTurnoActual() && jugador.jugarCartaEspecial(carta,
  // this.tablero, zonaEspeciales)) {
  // this.adminTurnos.siguienteTurno();
  // return true;
  // }
  // return false;
  // }
  //
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
