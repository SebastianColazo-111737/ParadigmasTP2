package edu.fiuba.algo3.modelo.jugador.atril;

import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.*;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;

public class Atril {
  private List<Seccion> secciones;
  private SeccionEspecial especiales;

  public Atril() {
    this.secciones = new ArrayList<>();
    this.especiales = new SeccionEspecial();
  }

  public void agregarSeccion(Seccion seccion) {
    secciones.add(seccion);
  }

  public List<Seccion> getSecciones() {
    return this.secciones;
  }

  public void colocarEspecial(CEspecial carta) {
    if(!especiales.estaVacia()){
      throw new NoPermiteColocarEspecialSiYaHayUna("Ya hay una carta especial activa en esta ronda.");
    }
    this.especiales.agregarCarta(carta);
  }

  public boolean hayCartaEspecialActiva(){
    return !especiales.estaVacia();
  }

  public void limpiarCartaEspecial(){
    especiales.limpiar();
  }

  public ICarta quemarCartaMasFuerte() {
    ArrayList<Unidad> cartas = new ArrayList<>();
    Unidad fuerte = null;

    for (Seccion seccion : this.secciones) {
      Unidad carta = seccion.tomarCartaMasFuerte();
      if (carta != null)
        cartas.add(seccion.tomarCartaMasFuerte());
    }

    if (cartas.size() == 0) {
      return fuerte;
    }
    fuerte = cartas.get(0);
    for (Unidad carta : cartas) {
      if (carta.masFuerteQue(fuerte))
        fuerte = carta;
    }
    this.descartarCarta(fuerte);
    return fuerte;
  }

  private void descartarCarta(Unidad carta) {
    for (Seccion seccion : this.secciones) {
      if (seccion.contieneCarta(carta)) {
        seccion.removerCarta(carta);
      }
    }
  }

  public void aplicar(ArrayList<Posicion> posicionesAfectadas, Consumer<Seccion> efecto) {
    for (Posicion posicion : posicionesAfectadas) {
      for (Seccion seccion : this.secciones) {
        if (seccion.compararPosiciones(posicion)) {
          efecto.accept(seccion);
        }
      }
    }
  }

  public void duplicarPuntos(Posicion posicion) {
    ArrayList<Posicion> p = new ArrayList<>();
    p.add(posicion);
    aplicar(p, Seccion::agregarDuplicador);
  }

  public void activarDebuff(ArrayList<Posicion> posicionesAfectadas) {
    aplicar(posicionesAfectadas, Seccion::activarDebuff);
  }

  public void limpiarDebuff(ArrayList<Posicion> posicionesAfectadas) {
    aplicar(posicionesAfectadas, Seccion::limpiarDebuff);
  }

  public void colocarCarta(ICarta carta, Posicion posicion) {

    for (Seccion seccion : this.secciones) {
      if (seccion.compararPosiciones(posicion)) {
        seccion.colocarUnidad((Unidad) carta);

      }
    }
  }

  public boolean contiene(Seccion seccion) {
    return this.secciones.contains(seccion);
  }

  public int getPuntajeActual() {
    int puntajeActual = 0;
    for (Seccion seccion : secciones) {
      puntajeActual += seccion.calcularPuntajeActualUnidades().getPuntajeActual(); // Tell dont ask -> fix
    }
    return puntajeActual;
  }

  public ArrayList<ICarta> descartarCartas() {
    ArrayList<ICarta> cartasDescarte = new ArrayList<>();
    for (Seccion seccion : secciones) {
      List<Unidad> cartas = seccion.removerCartasJugadas();
      cartasDescarte.addAll(cartas);
    }
    cartasDescarte.addAll(this.especiales.limpiar());
    return cartasDescarte;
  }

}
