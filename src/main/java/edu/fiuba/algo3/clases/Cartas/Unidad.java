package edu.fiuba.algo3.clases.Cartas;

import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Tipos.*;
import java.util.ArrayList;

public class Unidad implements Carta {
  private String nombre;
  private int puntosBase;
  private Tipo tipo;
  private Modificador modificador;
  private int puntosModificados;

  public Unidad(String nombre, int puntosBase, Tipo tipo, Modificador modificador) {
    this.nombre = nombre;
    this.puntosBase = puntosBase;
    this.puntosModificados = puntosBase;
    this.tipo = tipo;
    this.modificador = modificador;
  }

  public Modificador getModificador() {
    return this.modificador;
  }

  public Boolean compararCon(Carta carta) {
    return this.esMismoTipo(carta) && this.nombre == carta.getName();
  }

  public Boolean jugar(ArrayList<Seccion> secciones, Tipo tipo, Jugador jugadorSiguiente) {
    Boolean seJugo = false;
    for (Seccion seccion : secciones) {
      if (seccion.compararCon(tipo)) {
        seJugo = seccion.colocarUnidad(this);
      }
    }
    if (this.poseeModificador() && seJugo)
      this.modificador.aplicar(this, secciones, jugadorSiguiente, tipo);
    return true;
  }

  public boolean poseeModificador() {
    return this.modificador != null;
  }

  public int getPuntosModificados() {
    return this.puntosModificados;
  }

  public void sumarPuntosModificados(int puntos) {
    this.puntosModificados += puntos;
  }

  public void reiniciarPuntos() {
    this.puntosModificados = this.puntosBase;
  }

  public int obtenerPuntosBase() {
    return this.puntosBase;
  }

  public Tipo getTipo() {
    return this.tipo;
  }

  public boolean esMismoTipo(Carta carta) {
    return this.tipo.esIgual(carta.getTipo());
  }

  public String getName() {
    return this.nombre;
  }

}
