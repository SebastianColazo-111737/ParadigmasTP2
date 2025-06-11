
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.*;

public class Medico extends Modificador {
  private Carta cartaARevivir;

  public Medico(Carta cartaARevivir) {
    this.cartaARevivir = cartaARevivir;
    this.esLegendaria = false;
  }


  @Override
  public void aplicarEfecto(Carta cartaContexto, Tablero tablero, Jugador Jugador) {
    if(!jugador.getDescarte().contiene(cartaARevivir)){
      throw new IllegalArgumentException("La carta a revivir no está en la pila de descarte");
    }

    jugador.getDescarte().quitarCarta(cartaARevivir);

    if(!(cartaARevivir instanceof  Unidad)){
      throw new UnsupportedOperationException("Solo se pueden revivir Unidades");
    }
    tablero.colocarUnidad(jugador, cartaARevivir, Posicion.A_DISTANCIA);
  }
}
