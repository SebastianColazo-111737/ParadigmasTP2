package edu.fiuba.algo3.clases;

import java.util.List;
import java.util.ArrayList;

public class Descarte {
  private List<Carta> pilaDeDescarte;

  public Descarte() {
    this.pilaDeDescarte = new ArrayList<>();
  }

  public void descartar(Carta carta) {
    pilaDeDescarte.add(carta);
  }

  public int getCantCartasEnPila() {
    return pilaDeDescarte.size();
  }
}
