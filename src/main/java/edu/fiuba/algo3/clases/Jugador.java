package edu.fiuba.algo3.clases;

import edu.fiuba.algo3.clases.Cartas.*;
import java.util.List;
import java.util.ArrayList;
import edu.fiuba.algo3.clases.Tipos.*;

public class Jugador {
  private String nombre;
  private Mazo mazo;
  private ArrayList<Carta> mano;
  private ArrayList<Carta> descarte;
  private ArrayList<Seccion> secciones;

  public Jugador(String nombre, Mazo mazo) {
    this.mazo = mazo;
    this.nombre = nombre;
    this.mano = new ArrayList<>();
    this.descarte = new ArrayList<>();
    this.secciones = crearSecciones();
  }

  private ArrayList<Seccion> crearSecciones() {
    ArrayList<Seccion> s = new ArrayList<>();
    Asedio a = new Asedio();
    CuerpoACuerpo c = new CuerpoACuerpo();
    Distancia d = new Distancia();
    s.add(new Seccion(a));
    s.add(new Seccion(c));
    s.add(new Seccion(d));
    return s;
  }

  public String getName() {
    return this.nombre;
  }

  public void repartirMano() {
    for (int i = 0; i < 10; i++) {
      this.mano.add(mazo.tomarUltimaCarta());
    }
  }

  public void robarCartas(int cantidad) {
    List<Carta> cartasRobadas = this.mazo.darCartas(cantidad);
    this.mano.addAll(cartasRobadas);
  }

  public Boolean cartaExisteEnMazo(Carta carta) {
    return this.mano.indexOf(carta) != -1 ? true : false;
  }

  public ArrayList<Unidad> getUnidadesEnSeccion(Tipo tipo) {
    for (Seccion seccion : this.secciones)
      if (seccion.compararCon(tipo))
        return seccion.getUnidadesSeccion();
    return null;
  }

  public int getPuntajeEnSeccion(Tipo tipo) {
    for (Seccion seccion : this.secciones)
      if (seccion.compararCon(tipo))
        return seccion.obtenerPuntaje();
    return 0;
  }

  public int getCantidadCartasEnSeccion(Tipo tipo) {
    for (Seccion seccion : this.secciones)
      if (seccion.compararCon(tipo)) {
        System.out.println("Cantidad en seccion " + seccion.getCantUnidades() + " " + tipo.getClass());
        return seccion.getCantUnidades();
      }
    return 0;
  }

  public void limpiarSecciones() {
    for (Seccion seccion : this.secciones) {
      this.descarte.addAll(seccion.getUnidadesSeccion());
      seccion.limpiar();
    }
  }

  public Boolean jugar(Carta carta, Tipo posicion, Jugador jugadorSiguiente) {
    if (this.mano.indexOf(carta) == -1) {
      return false;
    }
    Boolean seColoco = carta.jugar(this.secciones, posicion, jugadorSiguiente);
    if (seColoco) {
      this.mano.remove(this.mano.indexOf(carta));
    }
    return seColoco;
  }

  // public Boolean jugarCartaEspecial(Especial carta, Tablero tablero,
  // ZonaEspeciales zonaEspeciales) {
  // Boolean seColoco = carta.jugarEspecial(tablero, this, zonaEspeciales);
  // if (seColoco) {
  // descartarCarta(carta);
  // }
  // return seColoco;
  // }
  //
  public void descartarCarta(Carta carta) {
    this.descarte.add(carta);
  }

  public int cartasEnElMazo() {
    return mazo.getCantCartas();
  }

  public int cantidadCartasEnMano() {
    return mano.size();
  }

  public int cantidadCartasEnDescarte() {
    return this.descarte.size();
  }

  public Mazo getMazo() {
    return this.mazo;
  }

  public ArrayList<Carta> getMano() {
    return this.mano;
  }

  public ArrayList<Carta> getDescarte() {
    return this.descarte;
  }
}
