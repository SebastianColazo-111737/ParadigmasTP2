package edu.fiuba.algo3.clases.Seccion;

import edu.fiuba.algo3.clases.Carta.*;
import edu.fiuba.algo3.modelo.Posicion.IPosicion;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private IPosicion posicion;
    private List<Unidad> unidadesColocadas;
    private int puntaje;

    public Seccion(IPosicion posicion){
        this.posicion = posicion;
        this.unidadesColocadas = new ArrayList<>();
    }

    public void colocarUnidad(Unidad unidad){
        if(unidad.sePuedeColocarEnLaPosicion(this.posicion)){
            unidadesColocadas.add(unidad);
            puntaje += unidad.calcularPuntaje();
        }
    }



    public int getPuntaje(){
        return this.puntaje;
    }

    public List<Unidad> getUnidadesColocadas(){
        List<Unidad> cartasParaDescartar = this.unidadesColocadas;
        this.unidadesColocadas = new ArrayList<>();
        return cartasParaDescartar;
    }

    public int getCantidadDeUnidadesColocadas(){
        return unidadesColocadas.size();
    }
}
