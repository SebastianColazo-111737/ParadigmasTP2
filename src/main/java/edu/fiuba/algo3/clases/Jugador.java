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

  public Boolean cartaExisteEnMano(Carta carta) {
    return this.mano.indexOf(carta) != -1;
  }

  public ArrayList<Unidad> getUnidadesEnSeccion(Tipo tipo) {
    Seccion s = this.buscarSeccion(tipo);
    return s != null ? s.getUnidadesSeccion() : null;
  }

  public int getPuntajeEnSeccion(Tipo tipo) {
    Seccion s = this.buscarSeccion(tipo);
    return s != null ? s.obtenerPuntaje() : 0;
  }

  public Seccion buscarSeccion(Tipo tipo) {
    ArrayList<Tipo> tipos = new ArrayList<>();
    tipos.add(tipo);

    for (Seccion seccion : this.secciones)
      if (seccion.compararCon(tipos)) {
        return seccion;
      }
    return null;
  }

  public int getCantidadCartasEnSeccion(Tipo tipo) {
    Seccion s = this.buscarSeccion(tipo);
    return s != null ? s.getCantUnidades() : 0;
  }

  public void limpiarSecciones() {
    for (Seccion seccion : this.secciones) {
      this.descarte.addAll(seccion.getUnidadesSeccion());
      seccion.limpiar();
    }
  }

  public Boolean jugar(Carta carta, Tipo posicion, Jugador jugadorSiguiente) {

    if (!this.cartaExisteEnMano(carta)) {
      return false;
    }

    int cantCartas = carta.jugar(this.buscarSeccion(posicion), this, jugadorSiguiente);
    if (cantCartas >= 0) {

      this.mano.remove(this.mano.indexOf(carta));
      for (int i = 0; i < cantCartas; i++) {
        this.mano.add(this.mazo.tomarUltimaCarta());
      }
    }
    return cantCartas >= 0;
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
