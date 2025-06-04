package edu.fiuba.algo3.falopa;

import edu.fiuba.algo3.falopa.Tipos.*;
import java.util.ArrayList;

public class Seccion {
  private ArrayList<Carta> cartas;
  private Tipo.Carta tipo;

  public Seccion(Tipo.Carta tipo) {
    this.cartas = new ArrayList<>();
    this.tipo = tipo;
  }

  public void addCarta(Carta carta) {
    this.cartas.add(carta);
  }

  public int calcularPuntajeSeccion() {
    int puntaje = 0;
    for (int i = 0; i < cartas.size(); i++) {
      puntaje += cartas.get(i).getValorAtaque();
    }
    return puntaje;
  }

  public int cantidadCartas() {
    return this.cartas.size();
  }

  public Carta retirarUltimaCarta() {
    return this.cartas.remove(this.cartas.size() - 1);
  }

  public ArrayList<Carta> getSeccion() {
    return this.cartas;
  }

  public Boolean validarCarta(Carta carta) {
    return carta.getTipo() == this.tipo;
  }
}
