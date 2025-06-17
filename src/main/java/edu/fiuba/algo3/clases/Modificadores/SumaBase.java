
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.*;

public class SumaBase extends Modificador {
  public SumaBase() {
    this.soyEspia = false;
  }

  @Override
  public boolean soyEspia() {
    return this.soyEspia;
  }

  @Override
  public int aplicar(Unidad cartaContexto, Seccion seccionContexto, Jugador jugadorActual, Jugador jugadorSiguiente) {

    for (Unidad carta : seccionContexto.getUnidadesSeccion()) {
      if (!carta.equals(cartaContexto))
        carta.sumarPuntosModificados(1);
    }

    return 0;
  }
}
