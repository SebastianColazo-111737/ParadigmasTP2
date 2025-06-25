
package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import java.util.ArrayList;

public class DeBuffCleaner extends CEspecial {
  public DeBuffCleaner(String nombre, ArrayList<Posicion> posicionAfectar) {
    super(nombre, posicionAfectar);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {

    // Arreglar lo de posicion -> Luego checo
    jugadorActual.colocarCartaEspecial(this);
    jugadorActual.limpiarDebuff(this.posicionesAfectar);
    jugadorSiguiente.limpiarDebuff(this.posicionesAfectar);

  }

  public String nombre() {
    return this.nombre;
  }
}
