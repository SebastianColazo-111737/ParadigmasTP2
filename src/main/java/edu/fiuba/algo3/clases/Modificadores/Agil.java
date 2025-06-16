
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.*;
import java.util.ArrayList;
import edu.fiuba.algo3.clases.Tipos.Tipo;

public class Agil extends Modificador {
  public Agil(ArrayList<Tipo> tipos, Unidad unidad) {
    this.esLegendaria = false;
    this.soyEspia = false;
  }

  public boolean soyEspia() {
    return this.soyEspia;
  }

  public int aplicar(Unidad cartaContexto, ArrayList<Seccion> secciones, Jugador jugadorSiguiente,
      Tipo posicion) {
    return 0;
  }
}
