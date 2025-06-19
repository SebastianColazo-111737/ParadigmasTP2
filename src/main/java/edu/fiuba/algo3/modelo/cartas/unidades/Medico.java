package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Medico extends Unidad{

    private Unidad unidadParaRevivir;
    private Seccion seccionParaColocarUnidad;

    public Medico(String nombre, Puntaje puntaje, Posicion posicion){
        super(nombre,puntaje,posicion);
        this.unidadParaRevivir = null;
        this.seccionParaColocarUnidad = null;
    }

    public void setUnidadParaRevivir(Unidad unidad,Seccion seccionParaColocarUnidad ){
        this.unidadParaRevivir = unidad;
        this.seccionParaColocarUnidad = seccionParaColocarUnidad;
    }

    @Override
    public void jugarCarta(Jugador jugador, Seccion seccion) {
        if(!jugador.lePertenece(seccion)){
            throw new UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion("");
        }

        seccion.colocarUnidad(this);

        if(unidadParaRevivir != null){
            //Necesito que el jugador la tenga en la mano para poder jugarla
            jugador.agregarCartaALaMano(unidadParaRevivir);
            jugador.jugarCarta(unidadParaRevivir, seccionParaColocarUnidad);
        }
    }
}
