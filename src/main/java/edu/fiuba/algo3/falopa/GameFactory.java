package edu.fiuba.algo3.falopa;

import java.util.ArrayList;

import edu.fiuba.algo3.falopa.Tipos.Tipo;

public class GameFactory {
  public static Juego crearJuego(String nombreJugador1, String nombreJugador2) {
    return new Juego(crearJugadores(nombreJugador1, nombreJugador2), crearSecciones());
  }

  public static ArrayList<Jugador> crearJugadores(String nombreJ1, String nombreJ2) {
    ArrayList<Jugador> jugadores = new ArrayList<>();
    jugadores.add(new Jugador(nombreJ1, crearMazo()));
    jugadores.add(new Jugador(nombreJ2, crearMazo()));
    return jugadores;
  }

  public static ArrayList<Seccion> crearSecciones() {
    ArrayList<Seccion> s = new ArrayList<>();
    s.add(new Seccion(Tipo.Carta.ASEDIO));
    s.add(new Seccion(Tipo.Carta.DISTANCIA));
    s.add(new Seccion(Tipo.Carta.INFANTERIA));
    s.add(new Seccion(Tipo.Carta.INFANTERIA));
    s.add(new Seccion(Tipo.Carta.DISTANCIA));
    s.add(new Seccion(Tipo.Carta.ASEDIO));
    return s;
  }

  public static Mazo crearMazo() {
    Mazo m = new Mazo(fabricarCartas());
    return m;

  }

  public static ArrayList<Carta> fabricarCartas() {
    ArrayList<Carta> cartas = new ArrayList<>();
    for (int i = 0; i < 21; i++) {
      Carta carta = new Carta("pepe" + i, i - 4);
      cartas.add(carta);
    }
    return cartas;
  }

}
