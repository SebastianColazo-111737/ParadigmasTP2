
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.*;
import java.util.ArrayList;
import edu.fiuba.algo3.clases.Tipos.Tipo;

public class SumaBase extends Modificador {
  public SumaBase() {
    this.esLegendaria = false;
    this.soyEspia = false;
  }

  public boolean soyEspia() {
    return this.soyEspia;
  }

  public int aplicar(Unidad cartaContexto, ArrayList<Seccion> secciones, Jugador jugadorSiguiente,
      Tipo posicion) {

    ArrayList<Unidad> cartas = null;
    for (Seccion seccion : secciones) {
      if (seccion.compararCon(posicion)) {
        cartas = seccion.getUnidadesSeccion();
      }
    }

    for (Unidad carta : cartas) {
      if (!carta.equals(cartaContexto))
        carta.sumarPuntosModificados(1);
    }

    return 0;
  }
}
