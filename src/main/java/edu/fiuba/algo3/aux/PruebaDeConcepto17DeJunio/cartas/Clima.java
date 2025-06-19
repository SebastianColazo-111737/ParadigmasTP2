package edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.cartas;

import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.Jugador;
import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.Seccion;
import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.posiciones.Posicion;

public class Clima implements ICarta {

    private Posicion posicionAfectada;

    public Clima(Posicion posicionAfectada){
        this.posicionAfectada = posicionAfectada;
    }


    @Override
    public void jugar(Jugador jugador, Seccion seccion) {

        // puede que la seccion que reciba ya sea la ZONA DE CLIMAS
        // y simplemente hago
        // seccion.agregarClima(this);


        // otra opcion es esta
        // jugador.agregarClima(this);
    }
}
