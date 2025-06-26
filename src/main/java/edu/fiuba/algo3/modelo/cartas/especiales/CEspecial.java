
package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public abstract class CEspecial implements ICarta {

  protected String nombre;
  protected ArrayList<Posicion> posicionesAfectar;

  public CEspecial(String nombre, ArrayList<Posicion> posicionAfectar) {
    this.nombre = nombre;
    this.posicionesAfectar = new ArrayList<>(posicionAfectar);
  }

  public boolean sePuedeColocar(Posicion posicion) {
    return true;
  }

  public List<Posicion> getTipo() {
    return null;// Es especial luego lo creo;
  }

}
