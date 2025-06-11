package edu.fiuba.algo3.clases.Carta;

import edu.fiuba.algo3.clases.Posicion.IPosicion;
import edu.fiuba.algo3.clases.Seccion.Seccion;

public class Unidad implements ICarta{
    private IPosicion posicion;
    private int puntaje;

    public Unidad(IPosicion posicion, int puntajeInicial){
        this.posicion = posicion;
        this.puntaje = puntajeInicial;
    }

    @Override
    public void jugarCarta(Seccion seccion) {
        seccion.colocarUnidad(this);
    }

    public boolean sePuedeColocarEnLaPosicion(IPosicion posicion){
        return posicion.esCompatible(posicion);
    }

    public int calcularPuntaje(){
        return this.puntaje;
    }
}
