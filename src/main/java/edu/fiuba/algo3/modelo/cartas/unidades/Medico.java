package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Medico extends Unidad {

  private Unidad unidadParaRevivir;
  private Posicion poscionUnidadParaRevivir;

  public Medico(String nombre, Puntaje puntaje, Posicion posicion) {
    super(nombre, puntaje, posicion);
  }

  public void setUnidadParaRevivir(Unidad unidad, Posicion posicion) {
    this.unidadParaRevivir = unidad;
    this.poscionUnidadParaRevivir = posicion;
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {
    // Si esta carta se jugó hay que usar la carta que revivió -> Ojito
    jugadorActual.colocarUnidad(this, posicion);
    if (unidadParaRevivir != null) {
      // puedo agregar un metodo a jugador para que saque la carta de la pila de
      // descarte
      // y luego la juegue como jugador.revivirCarta(ICarta)
      jugadorActual.jugarCarta(this.unidadParaRevivir, jugadorSiguiente, this.poscionUnidadParaRevivir);
    }
  }

  public String nombre() {
    return this.nombre;
  }

}
