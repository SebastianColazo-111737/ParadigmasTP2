
package edu.fiuba.algo3.clases.Modificadores;

import java.util.ArrayList;

import edu.fiuba.algo3.clases.*;

public class Unidas extends Modificador {
  public Unidas() {
    this.esLegendaria = false;
  }

  @Override
  public void aplicarEfecto(Carta cartaContexto, Tablero tablero, Jugador Jugador) {
    ArrayList<Unidad> cartasEnSeccion = tablero.getUnidadesEnSeccion(cartaContexto.getPosicion(), Jugador);

    for (Unidad carta : cartasEnSeccion) {
      if (carta.getName() == cartaContexto.getName()) {
        carta.sumarPuntosModificados(carta.obtenerPuntosBase());
      }
    }
  }
}
