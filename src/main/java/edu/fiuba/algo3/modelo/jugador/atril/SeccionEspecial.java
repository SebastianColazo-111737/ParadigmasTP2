package edu.fiuba.algo3.modelo.jugador.atril;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;

public class SeccionEspecial {
  private ArrayList<CEspecial> cartas;

  public SeccionEspecial() {
    this.cartas = new ArrayList<>();
  }

  public void agregarCarta(CEspecial carta) {
    this.cartas.add(carta);
  }

  public ArrayList<ICarta> limpiar() {
    ArrayList<ICarta> copia = new ArrayList<>(this.cartas);
    this.cartas.clear();
    return copia;
  }

}
