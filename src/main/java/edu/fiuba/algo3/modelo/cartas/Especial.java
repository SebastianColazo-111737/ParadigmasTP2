package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.jugador.Seccion;

public abstract class Especial extends Carta{
    @Override
    public void jugarEnSeccion(Seccion seccion) {
        seccion.recibirHechizo(this);
        //seccion.aplicarHechizo();  // ¿hago que se active aca? envio la especial
                                   // seccion.aplicarHechizo(thisCarta) -> carta.activar(thisSeccion), o
    }                              // ¿hago que seccion active a todas las unidades a la vez?
                                   // seccion.aplicarHechizoS() desde Juego.

}
