package edu.fiuba.algo3.clases.Cartas;

import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Tipos.*;
import java.util.ArrayList;

public interface Carta {
  String getName();

  int jugar(Seccion seccion, Jugador jugadorActual, Jugador jugadorSiguiente);

  Boolean compararCon(Carta carta);

  ArrayList<Tipo> getTipo();
}
