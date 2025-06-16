
package edu.fiuba.algo3.clases.Tipos;

public class Distancia extends Tipo {
  @Override
  public boolean esIgual(Tipo unTipo) {
    return this.getClass().equals(unTipo.getClass());
  }
}
