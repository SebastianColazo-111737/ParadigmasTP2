
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import java.util.ArrayList;
import edu.fiuba.algo3.clases.Tipos.Tipo;
import edu.fiuba.algo3.clases.*;

public class Unidas extends Modificador {

  public Unidas() {
    this.esLegendaria = false;
    this.soyEspia = false;
  }

  @Override
  public boolean soyEspia() {
    return this.soyEspia;
  }

  @Override
  public int aplicar(Unidad cartaContexto, ArrayList<Seccion> secciones, Jugador jugadorSiguiente,
      Tipo posicion) {
    ArrayList<Unidad> cartasEnSeccion = null;
    // Para evitar esto es mejor crear una clase (?)
    for (Seccion seccion : secciones) {
      if (seccion.compararCon(posicion)) {
        cartasEnSeccion = seccion.getUnidadesSeccion();
      }
    }

    for (Unidad carta : cartasEnSeccion) {
      if (carta.compararCon(cartaContexto) && !carta.equals(cartaContexto)) {
        carta.sumarPuntosModificados(cartaContexto.obtenerPuntosBase());
      }
    }
    return 0;
  }
}
