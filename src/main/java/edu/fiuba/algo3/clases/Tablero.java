package edu.fiuba.algo3.clases;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Tablero {
  private Map<Jugador, HashMap<Posicion, Seccion>> lado;

  public Tablero(Jugador jugador1, Jugador jugador2) {
    this.lado = new HashMap<>();
    this.lado.put(jugador1, crearSecciones());
    this.lado.put(jugador2, crearSecciones());
  }

  private HashMap<Posicion, Seccion> crearSecciones() {
    HashMap<Posicion, Seccion> s = new HashMap<>();
    s.put(Posicion.ASEDIO, new Seccion(Posicion.ASEDIO));
    s.put(Posicion.A_DISTANCIA, new Seccion(Posicion.A_DISTANCIA));
    s.put(Posicion.CUERPO_A_CUERPO, new Seccion(Posicion.CUERPO_A_CUERPO));

    return s;
  }

  public Boolean colocarUnidad(Unidad unidad, Jugador jugador, Posicion posicion) {
    return this.lado.get(jugador).get(posicion).colocarUnidad(unidad);
  }


  public int getPuntajeEnSeccion(Jugador jugador, Posicion posicion) {
    return this.lado.get(jugador).get(posicion).obtenerPuntaje();
  }

  public int getCantidadCartasEnSeccion(Jugador jugador, Posicion posicion) {
    return this.lado.get(jugador).get(posicion).getCantUnidades();
  }




}
