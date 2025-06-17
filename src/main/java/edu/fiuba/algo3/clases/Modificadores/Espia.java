
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.*;
import java.util.ArrayList;

public class Espia extends Modificador {
  public Espia() {
    this.soyEspia = true;
  }

  @Override
  public boolean soyEspia() {
    return this.soyEspia;
  }

  @Override
  public int aplicar(Unidad cartaContexto, Seccion seccionContexto, Jugador jugadorActual, Jugador jugadorSiguiente) {

    ArrayList<Unidad> seccionAsedioEnemiga = jugadorSiguiente.getUnidadesEnSeccion(seccionContexto.getTipo());
    // Faltan las condiciones
    seccionAsedioEnemiga.add(cartaContexto);
    return 2;
  }
}
