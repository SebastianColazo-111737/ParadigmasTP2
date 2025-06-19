package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class General extends Unidad{
    public General(String nombre, Puntaje puntaje, Posicion posicion){
        super(nombre,puntaje,posicion);
    }

    @Override
    public void jugarCarta(Jugador jugador, Seccion seccion) {
        if(!jugador.lePertenece(seccion)){
            throw new UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion("");
        }
        seccion.colocarUnidad(this);
    }
}
