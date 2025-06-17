package edu.fiuba.algo3.clases;

import edu.fiuba.algo3.clases.Cartas.*;

public abstract class Modificador {
  protected boolean soyEspia;

  public abstract int aplicar(Unidad cartaContexto, Seccion seccionContexto,
      Jugador jugadorActual, Jugador jugadorSiguiente);

  public abstract boolean soyEspia();
}
