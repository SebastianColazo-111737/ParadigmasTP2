package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.List;

public class Carta {
    private String nombre;
    private List<Posicion> posiciones;
    private Boolean esDeMapa;

    public Boolean compararPosicion(Posicion otraPosicion){
        Boolean esCompatible = false;
        for(Posicion posicion : posiciones){
            esCompatible = posicion.esCompatible(otraPosicion);
        }
        return esCompatible;
    }

    public Boolean esDeMapa(){return this.esDeMapa;}
}
