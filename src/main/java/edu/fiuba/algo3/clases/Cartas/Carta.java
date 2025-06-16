package edu.fiuba.algo3.clases.Cartas;

import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Tipos.*;
import java.util.ArrayList;

public interface Carta {
  String getName();

  int jugar(ArrayList<Seccion> secciones, Tipo posicion, Jugador jugadorSiguiente);

  Boolean compararCon(Carta carta);

  Tipo getTipo();
}
