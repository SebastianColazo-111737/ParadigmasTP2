
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Tipos.*;
import java.util.ArrayList;

public class Medico extends Modificador {
  private Carta cartaARevivir;
  private Tipo cartaARevivirPos;

  public Medico() {
    this.esLegendaria = false;
  }

  public ArrayList<Carta> aplicar(Unidad cartaContexto, ArrayList<Seccion> secciones, Jugador jugadorSiguiente,
      Tipo posicion) {
    if (this.cartaARevivir == null) {
      return null;
    }
    // idem
    for (Seccion seccion : secciones) {
      if (seccion.compararCon(this.cartaARevivirPos)) {
        // Arreglar para que no se tenga que castear !!!!!!!!!!!!!!!!!!!!!!!!!
        seccion.colocarUnidad((Unidad) this.cartaARevivir);
      }
    }

    return null;
  }

  public void setCartaRevivir(Carta carta, Tipo posicion) {
    this.cartaARevivir = carta;
    this.cartaARevivirPos = posicion;
  }
}
