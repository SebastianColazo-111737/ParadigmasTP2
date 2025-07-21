
package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import java.util.ArrayList;
import java.util.List;

public class Debuff extends CEspecial {
  public Debuff(String nombre, ArrayList<Posicion> posicionAfectar, String descripcion) {
    super(nombre, posicionAfectar, descripcion);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {
    jugadorActual.colocarCartaEspecial(this);
    jugadorActual.activarDebuff(this.posicionesAfectar);
    jugadorSiguiente.activarDebuff(this.posicionesAfectar);

  }

  public String nombre() {
    return this.nombre;
  }

  public List<Posicion> getPosicionAfectar() {
    return this.posicionesAfectar;
  }
}
