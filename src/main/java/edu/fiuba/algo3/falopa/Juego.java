package edu.fiuba.algo3.falopa;

import java.util.ArrayList;

public class Juego {
  private ArrayList<Jugador> jugadores;
  private ArrayList<Seccion> secciones;
  private AdminTurnos adminTurnos;

  public Juego(ArrayList<Jugador> jugadores, ArrayList<Seccion> secciones) {
    this.jugadores = jugadores;
    this.secciones = secciones;
    this.adminTurnos = new AdminTurnos();
  }

  public int cantidadCartasEnSeccion(int indiceSeccion) {
    return this.secciones.get(indiceSeccion).cantidadCartas();
  }

  public Boolean colocarCarta(int indiceJugador, int indiceCartaEnMano, int indiceSeccion) {
    if (indiceJugador != this.adminTurnos.getIndiceJugadorActual()) {
      return false;
    }
    Carta cartaSeleccionada = getJugadorActual().obtenerCartaEnMano(indiceCartaEnMano);
    this.secciones.get(indiceSeccion).addCarta(cartaSeleccionada);
    adminTurnos.siguienteTurno();
    return true;
  }

  public int getPuntajeJugador(int indiceJugador) {
    int puntaje = 0;
    if (indiceJugador == 0) {
      for (int i = 0; i < secciones.size() - 3; i++) {
        puntaje += secciones.get(i).calcularPuntajeSeccion();
      }
      return puntaje;
    }

    for (int i = 3; i < secciones.size(); i++) {
      puntaje += secciones.get(i).calcularPuntajeSeccion();
    }
    return puntaje;

  }

  public int cartasEnManoJugador(int indiceJugador) {
    return jugadores.get(indiceJugador).cantidadCartasEnMano();
  }

  public void repartirCartasDelMazoJugador(int indiceJugador) {
    this.jugadores.get(indiceJugador).repartirMano();
  }

  public int cartasEnElMazoJugador(int indiceJugador) {
    return jugadores.get(indiceJugador).cartasEnElMazo();
  }

  private Jugador getJugadorActual() {
    return jugadores.get(this.adminTurnos.getIndiceJugadorActual());
  }

  public int getIndiceJugadorActual() {
    return adminTurnos.getIndiceJugadorActual();
  }

  public int getIndiceJugadorSiguiente() {
    return adminTurnos.getIndiceJugadorSiguiente();
  }
}
