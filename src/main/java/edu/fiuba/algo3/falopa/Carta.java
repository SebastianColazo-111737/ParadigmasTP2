package edu.fiuba.algo3.falopa;

import edu.fiuba.algo3.falopa.Tipos.Tipo;

public class Carta {
  private String nombre;
  private int ataque;

  public Carta(String nombre, int ataque) {
    this.nombre = nombre;
    this.ataque = ataque;
  }

  public int getValorAtaque() {
    return this.ataque;
  }

  public String getName() {
    return this.nombre;
  }

  public Tipo.Carta getTipo() {
    return Tipo.Carta.ASEDIO;
  }
}
