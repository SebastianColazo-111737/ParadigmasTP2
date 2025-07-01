package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Medico extends Unidad {

  private ICarta cartaParaRevivir;
  private Posicion posicionCartaParaRevivir;

  public Medico(String nombre, Puntaje puntaje, Posicion posicion) {
    super(nombre, puntaje, posicion);
  }

  public void setUnidadParaRevivir(ICarta carta, Posicion posicion) {
    System.out.println("setUnidadParaRevivir invocado con: " + carta);
    this.cartaParaRevivir = carta;
    this.posicionCartaParaRevivir = posicion;
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {
    // Si esta carta se jugó hay que usar la carta que revivió -> Ojito
    jugadorActual.colocarUnidad(this, posicion);
    if (this.cartaParaRevivir != null) {
      this.cartaParaRevivir.jugar(jugadorActual, jugadorSiguiente, this.posicionCartaParaRevivir);
    }
  }

  public String nombre() {
    return this.nombre;
  }

  public boolean tieneUnidadParaRevivir(){
    return this.cartaParaRevivir != null;
  }

}
