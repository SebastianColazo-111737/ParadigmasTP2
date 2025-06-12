package edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.Posicion.IPosicion;
import edu.fiuba.algo3.modelo.Carta.Unidad;

import java.util.List;


public class Seccion {
    private IPosicion posicion;
    private List<Unidad> unidadesColocadas;

    public Seccion(IPosicion posicion){
        this.posicion = posicion;
    }

    public void colocarUnidad(Unidad unidad){
        if(unidad.sePuedeColocarEnLaPosicion(posicion)){
            unidadesColocadas.add(unidad);
        }
    }
}
