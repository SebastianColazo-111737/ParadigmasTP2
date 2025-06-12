
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.*;

public class Agil implements Modificador {
  //public Agil() {
  //  this.esLegendaria = false;
  //}

  public void aplicarEfectoNato(Unidad unidad, Posicion nuevaPosicion){
      // Entiendo que pueden colocarse en cualquier seccion
      unidad.cambiarPosicion(nuevaPosicion);
  }

  public void aplicarEfectoEnTablero(Carta cartaContexto, Tablero tablero, Jugador jugador) {}
}
