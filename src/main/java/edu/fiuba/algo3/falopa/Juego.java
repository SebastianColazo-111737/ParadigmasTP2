package edu.fiuba.algo3.falopa;

import java.util.ArrayList;

public class Juego {
  private ArrayList<Jugador> jugadores;
  private ArrayList<Seccion> secciones;

  public Juego(String nombreJ1, String nombreJ2) {

    this.secciones = crearSecciones();

    ArrayList<Jugador> jugadores = new ArrayList<>();
    jugadores.add(crearJugador(nombreJ1, crearMazo()));
    jugadores.add(crearJugador(nombreJ2, crearMazo()));

    this.jugadores = jugadores;
  }

  public int cantidadCartasEnSeccion(int indiceSeccion) {
    return this.secciones.get(indiceSeccion).cantidadCartas();
  }

  public void colocarCarta(int indiceJugador, int indiceCartaEnMano, int indiceSeccion) {
    Carta cartaSeleccionada = this.jugadores.get(indiceJugador).obtenerCartaEnMano(indiceCartaEnMano);
    this.secciones.get(indiceSeccion).addCarta(cartaSeleccionada);
  }

  public int cartasEnManoJugador(int indiceJugador) {
    return jugadores.get(indiceJugador).cantidadCartasEnMano();
  }

  public void repartirCartasDelMazoJugador(int indiceJugador) {
    this.jugadores.get(indiceJugador).repartirMano();
  }

  private Mazo crearMazo() {
    Mazo m = new Mazo(fabricarCartas());
    return m;

  }

  private ArrayList<Seccion> crearSecciones() {
    ArrayList<Seccion> s = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      s.add(new Seccion());
    }
    return s;
  }

  private Jugador crearJugador(String nombre, Mazo mazo) {
    return new Jugador(nombre, mazo);
  }

  public int cartasEnElMazoJugador(int indiceJugador) {
    return jugadores.get(indiceJugador).cartasEnElMazo();
  }

  public void insertarCartaSeccion(int index, Carta carta) {
    this.secciones.get(index).addCarta(carta);
  }

  public ArrayList<Carta> fabricarCartas() {
    ArrayList<Carta> cartas = new ArrayList<>();
    for (int i = 0; i < 21; i++) {
      Carta carta = new Carta("pepe" + i, i);
      cartas.add(carta);
    }
    return cartas;
  }

}
