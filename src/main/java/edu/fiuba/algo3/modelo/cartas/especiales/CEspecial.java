
package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.Especial;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;

public abstract class CEspecial implements ICarta {

  protected String nombre;
  protected ArrayList<Posicion> posicionesAfectar;
  protected String descripcion;

  public CEspecial(String nombre, ArrayList<Posicion> posicionAfectar, String descripcion) {
    this.nombre = nombre;
    this.posicionesAfectar = new ArrayList<>(posicionAfectar);
    this.descripcion = descripcion;
  }

  public boolean sePuedeColocar(Posicion posicion) {
    return true;
  }

  public ArrayList<Posicion> getTipo() {
    ArrayList<Posicion> t = new ArrayList<>();
    t.add(new Especial());
    return t;
  }

  public String descripcion() {
    return this.descripcion;
  }
}
