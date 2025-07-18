package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.*;
import java.util.List;

public interface ICarta {
  void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion);

  List<Posicion> getTipo();

  String nombre();

  default String colorHex() {
    return "FFF8DC";
  }

}
