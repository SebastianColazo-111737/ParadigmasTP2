package edu.fiuba.algo3.clases;

import java.util.List;
import java.util.ArrayList;

public class Juego {
  private List<Jugador> jugadores;
  private ArrayList<Seccion> secciones;
  private Tablero tablero;

  public Juego(Jugador jugador1, Jugador jugador2) {

    this.jugadores = new ArrayList<>();
    jugadores.add(jugador1);
    jugadores.add(jugador2);

    this.secciones = crearSecciones();
    this.tablero = new Tablero(jugador1, jugador2);
  }

  public int cantidadCartasEnSeccion(Jugador jugador, Posicion posicion) {
    Mesa mesa = tablero.getMesa(jugador);
    Seccion seccion = mesa.getSeccion(posicion);
    return seccion.getCantUnidades();
  }

  public void colocarCarta(int indiceJugador, int indiceCartaEnMano, int indiceSeccion) {
    Carta cartaSeleccionada = this.jugadores.get(indiceJugador).obtenerCartaEnMano(indiceCartaEnMano);
    this.secciones.get(indiceSeccion).addCarta(cartaSeleccionada);
  }

  public void jugarCarta(Jugador jugador, Carta carta) {
    jugador.jugarCarta(carta, this.tablero);
  }

  public void repartirCartasDelMazoJugador(int indiceJugador) {
    this.jugadores.get(indiceJugador).repartirMano();
  }

  public void repartirCartas() {
    for (Jugador jugador : jugadores) {
      jugador.robarCartas(10);
    }
  }

  public Carta obtenerCartaEnMano(int indiceJugador, int indiceCarta) {
    return this.jugadores.get(indiceJugador).obtenerCartaEnMano(indiceCarta);
  }

  private ArrayList<Seccion> crearSecciones() {
    ArrayList<Seccion> s = new ArrayList<>();
    for (Jugador jugador : jugadores) {
      s.add(new Seccion(jugador));
      s.add(new Seccion(jugador));
      s.add(new Seccion(jugador));
    }
    return s;
  }

  public int calcularPuntaje(int indiceJugador) {
    int puntaje = 0;
    for (Seccion seccion : secciones) {
      if (seccion.perteneceAJugador(jugadores.get(indiceJugador))) {
        puntaje += seccion.obtenerPuntaje();
      }
    }
    return puntaje;
  }

  public int cartasEnElMazoJugador(int indiceJugador) {
    return jugadores.get(indiceJugador).cartasEnElMazo();
  }

  public void insertarCartaSeccion(int index, Carta carta) {
    this.secciones.get(index).addCarta(carta);
  }

}
