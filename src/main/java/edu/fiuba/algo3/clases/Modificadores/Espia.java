
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.*;
import java.util.ArrayList;
import edu.fiuba.algo3.clases.Tipos.Tipo;

public class Espia extends Modificador {
  public Espia() {
    this.esLegendaria = false;
    this.soyEspia = true;
  }

  public boolean soyEspia() {
    return this.soyEspia;
  }

  public int aplicar(Unidad cartaContexto, ArrayList<Seccion> secciones, Jugador jugadorSiguiente,
      Tipo posicion) {

    ArrayList<Unidad> seccionAsedioEnemiga = jugadorSiguiente.getUnidadesEnSeccion(posicion);
    seccionAsedioEnemiga.add(cartaContexto);
    return 2;
  }
}
