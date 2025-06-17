
package edu.fiuba.algo3.clases.Tipos;

import java.util.ArrayList;

public class Asedio extends Tipo {
  @Override
  public boolean esIgual(ArrayList<Tipo> Tipos) {
    boolean equals = false;
    for (Tipo tipo : Tipos) {
      equals = this.getClass().equals(tipo.getClass());
    }
    return equals;
  }
}
