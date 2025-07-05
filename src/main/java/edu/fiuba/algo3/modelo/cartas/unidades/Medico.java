package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.Optional;

public class Medico extends Unidad {

  public Medico(String nombre, Puntaje puntaje, Posicion posicion) {
    super(nombre, puntaje, posicion);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {
    jugadorActual.colocarUnidad(this, posicion);

    Optional<ICarta> revivida = jugadorActual.revivirUltimaUnidadDescarte();

    if (revivida.isPresent()) {
      ICarta carta = revivida.get();
    } else {
      System.out.println(" → El médico no pudo revivir ninguna carta.");
    }
  }

  public String nombre() {
    return this.nombre;
  }

}
