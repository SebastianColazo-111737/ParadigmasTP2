
package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import java.util.ArrayList;

public class TierraArrasada extends CEspecial {
  public TierraArrasada(String nombre, ArrayList<Posicion> posicionAfectar, String descripcion) {
    super(nombre, posicionAfectar, descripcion);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {
    jugadorActual.colocarCartaEspecial(this);
    jugadorActual.quemarCartaMasFuerte();
    jugadorSiguiente.quemarCartaMasFuerte();
  }

  public String nombre() {
    return this.nombre;
  }

}
