package edu.fiuba.algo3.clases.Cartas;

import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Tipos.*;
import java.util.ArrayList;

public class Unidad implements Carta {
  private String nombre;
  private int puntosBase;
  private ArrayList<Tipo> tipo;
  private Modificador modificador;
  private int puntosModificados;
  private Boolean esLegendaria;

  public Unidad(String nombre, int puntosBase, ArrayList<Tipo> tipo, Modificador modificador, Boolean legendaria) {
    this.nombre = nombre;
    this.puntosBase = puntosBase;
    this.puntosModificados = puntosBase;
    this.tipo = tipo;
    this.modificador = modificador;
    this.esLegendaria = legendaria;
  }

  public Boolean esAgil() {
    return this.tipo.size() > 1;
  }

  public Boolean esLegendaria() {
    return this.esLegendaria;
  }

  public void agregarModificador(Modificador modificador) {
    this.modificador = modificador;
  }

  public Modificador getModificador() {
    return this.modificador;
  }

  public Boolean compararCon(Carta carta) {
    return this.esMismoTipo(carta) && this.nombre == carta.getName();
  }

  public int jugar(Seccion seccion, Jugador jugadorActual, Jugador jugadorSiguiente) {
    int seJugo = -1;
    System.out.println("Pasa por aca?" + seccion.getTipo());
    if (!(this.poseeModificador() && this.modificador.soyEspia())) {
      if (seccion.compararCon(this.tipo) && seccion.colocarUnidad(this)) {
        seJugo = 0;
      }
    } else {
      seJugo = 0;
    }
    if (this.poseeModificador() && seJugo == 0)
      return (this.modificador.aplicar(this, seccion, jugadorActual, jugadorSiguiente));
    return seJugo;
  }

  public boolean poseeModificador() {
    return this.modificador != null;
  }

  public int getPuntosModificados() {
    return this.puntosModificados;
  }

  public void sumarPuntosModificados(int puntos) {
    if (this.esLegendaria) {
      return;
    }
    this.puntosModificados += puntos;
  }

  public void reiniciarPuntos() {
    if (this.esLegendaria) {
      return;
    }
    this.puntosModificados = this.puntosBase;
  }

  public int obtenerPuntosBase() {
    return this.puntosBase;
  }

  public ArrayList<Tipo> getTipo() {
    return this.tipo;
  }

  public boolean esMismoTipo(Carta carta) {
    for (Tipo tipo : this.tipo) {
      return tipo.esIgual(carta.getTipo());
    }
    return false;
  }

  public String getName() {
    return this.nombre;
  }

}
