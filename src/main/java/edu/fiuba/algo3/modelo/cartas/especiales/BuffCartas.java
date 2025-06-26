
package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import java.util.ArrayList;

public class BuffCartas extends CEspecial {
  public BuffCartas(String nombre, ArrayList<Posicion> posicionAfectar) {
    super(nombre, posicionAfectar);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {

    jugadorActual.colocarCartaEspecial(this);
    jugadorActual.duplicarPuntos(posicion);
    jugadorSiguiente.duplicarPuntos(posicion);

  }

  public String nombre() {
    return this.nombre;
  }
}
