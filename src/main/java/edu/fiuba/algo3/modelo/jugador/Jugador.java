package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.*;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.*;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
  private Mazo mazo;
  private Mano mano;
  private Atril atril;
  private Descarte descarte;

  public Jugador(Mazo mazo, Mano mano, Atril atril) {
    this.mazo = mazo;
    this.mano = mano;
    this.atril = atril;
    this.descarte = new Descarte();

  }

  public void robarCartasDelMazo(int cantidad) {
    List<ICarta> cartasDelMazo = this.mazo.darCartas(cantidad);
    this.mano.agregarCarta(cartasDelMazo);
  }

  public void cambiarCartaDeLaManoAlMazo(ICarta carta) {
    mano.removerCarta(carta);

    ICarta cartaDelMazo = this.mazo.cambiarCarta(carta);
    agregarCartaALaMano(cartaDelMazo);
  }

  public void activarDebuff(ArrayList<Posicion> posicionesAfectadas) {
    this.atril.activarDebuff(posicionesAfectadas);
  }

  public void quemarCartaMasFuerte() {
    this.atril.quemarCartaMasFuerte();
  }

  public void duplicarPuntos(Posicion posicion) {
    this.atril.duplicarPuntos(posicion);
  }

  public void limpiarDebuff(ArrayList<Posicion> posicionesAfectadas) {
    this.atril.limpiarDebuff(posicionesAfectadas);
  }

  public void agregarCartaALaMano(ICarta carta) {
    this.mano.agregarCarta(carta);
  }

  public boolean lePertenece(Seccion seccion) {
    return this.atril.contiene(seccion);
  }

  public void jugarCarta(ICarta carta, Jugador jugadorSiguiente, Posicion tipo) {

    try {
      carta.jugar(this, jugadorSiguiente, tipo);
    } catch (Exception e) {
      throw e;
    }

    mano.removerCarta(carta);
  }

  public void colocarUnidad(ICarta carta, Posicion posicion) {
    atril.colocarCarta(carta, posicion);

  }

  public void colocarCartaEspecial(CEspecial carta) {
    atril.colocarEspecial(carta);

  }

  public Atril atril() {
    return this.atril;
  }

  public void limpiarTodo() {
    this.descarte.agregarCarta(this.atril.descartarCartas());
  }

  public Mano mano() {
    return this.mano;
  }

  public Mazo mazo(){
    return  this.mazo;
  }

  public List<ICarta> cartasDelDescarte(){
    return this.descarte.getCartas();
  }
}
