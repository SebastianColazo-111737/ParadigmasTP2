
package edu.fiuba.algo3.clases.Modificadores;

import edu.fiuba.algo3.clases.Cartas.*;
import edu.fiuba.algo3.clases.*;
import java.util.ArrayList;
import edu.fiuba.algo3.clases.Tipos.Tipo;

public class Espia extends Modificador {
  public Espia() {
    this.esLegendaria = false;
  }

  public ArrayList<Carta> aplicar(Unidad cartaContexto, ArrayList<Seccion> secciones, Jugador jugadorSiguiente,
      Tipo posicion) {
    return null;
  }
}
