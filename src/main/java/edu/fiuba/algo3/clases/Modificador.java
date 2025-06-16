package edu.fiuba.algo3.clases;

import edu.fiuba.algo3.clases.Cartas.*;
import java.util.ArrayList;
import edu.fiuba.algo3.clases.Tipos.Tipo;

public abstract class Modificador {
  protected boolean esLegendaria;
  protected boolean soyEspia;

  public abstract int aplicar(Unidad cartaContexto, ArrayList<Seccion> secciones,
      Jugador jugadorSiguiente, Tipo posicion);

  public abstract boolean soyEspia();
}
