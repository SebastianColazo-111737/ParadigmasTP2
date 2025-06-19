package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Espia extends Unidad{

    public Espia(String nombre, Puntaje puntaje, Posicion posicion){
        super(nombre,puntaje,posicion);
    }

    @Override
    public void jugarCarta(Jugador jugador, Seccion seccion) {
        if(jugador.lePertenece(seccion)){ //el espia no se puede jugar en las secciones del jugador
            throw new UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion("");
        }
        seccion.colocarUnidad(this);
        jugador.robarCartasDelMazo(2);
    }
}
