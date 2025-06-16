package edu.fiuba.algo3.clases.Tipos;

public class Asedio extends Tipo {
  @Override
  public boolean esIgual(Tipo unTipo) {
    return this.getClass().equals(unTipo.getClass());
  }
}
