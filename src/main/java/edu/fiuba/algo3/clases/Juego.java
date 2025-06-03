package edu.fiuba.algo3.clases;

import java.util.ArrayList;

public class Juego {
  private ArrayList<Jugador> jugadores;
  private ArrayList<Seccion> secciones;

  public Juego(String nombreJ1, String nombreJ2) {

    this.jugadores = new ArrayList<>();
    Jugador j1 = crearJugador(nombreJ1, crearMazo());
    Jugador j2 = crearJugador(nombreJ2, crearMazo());
    jugadores.add(j1);
    jugadores.add(j2);

    this.secciones = crearSecciones();
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

  public Carta obtenerCartaEnMano(int indiceJugador,int indiceCarta){
    return this.jugadores.get(indiceJugador).obtenerCartaEnMano(indiceCarta);
  }


  private Mazo crearMazo() {
    Mazo m = new Mazo(fabricarCartas());
    return m;

  }

  private ArrayList<Seccion> crearSecciones() {
    ArrayList<Seccion> s = new ArrayList<>();
    for(Jugador jugador : jugadores){
      s.add(new Seccion(jugador));
      s.add(new Seccion(jugador));
      s.add(new Seccion(jugador));
    }
    return s;
  }

  private Jugador crearJugador(String nombre, Mazo mazo) {
    return new Jugador(nombre, mazo);
  }

  public int obtenerPuntajeActualJugador(int indiceJugador){
    int puntaje = 0;
    for(Seccion seccion : secciones){
      if(seccion.perteneceAJugador(jugadores.get(indiceJugador))){
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

  public ArrayList<Carta> fabricarCartas() {
    ArrayList<Carta> cartas = new ArrayList<>();
    for (int i = 0; i < 21; i++) {
      Carta carta = new Unidad("pepe" + i, i);  // <-- esto antes era new Carta
      cartas.add(carta);
    }
    return cartas;
  }

}
