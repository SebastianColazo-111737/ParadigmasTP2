
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Tipos.*;

public class Medico extends Modificador {
  private Carta cartaARevivir;
  private Tipo cartaARevivirPos;

  public Medico() {
    this.soyEspia = false;
  }

  @Override
  public boolean soyEspia() {
    return this.soyEspia;
  }

  @Override
  public int aplicar(Unidad cartaContexto, Seccion seccionContexto, Jugador jugadorActual,
      Jugador jugadorSiguiente) {

    Seccion seccionPonerCarta = jugadorActual.buscarSeccion(this.cartaARevivirPos);
    this.cartaARevivir.jugar(seccionPonerCarta, jugadorActual, jugadorSiguiente);
    return 0;
  }

  public void setCartaRevivir(Carta carta, Tipo posicion) {
    this.cartaARevivir = carta;
    this.cartaARevivirPos = posicion;
  }
}
