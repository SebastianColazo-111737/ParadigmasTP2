package edu.fiuba.algo3.modelo.jugador.atril;

import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.cartas.*;


import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private Posicion posicion;
    private List<Unidad> unidadesColocadas;

    public Seccion(Posicion posiccion){
        this.posicion = posiccion;
        this.unidadesColocadas = new ArrayList<>();
    }

    public Boolean compararPosiciones(Posicion posicion){
        return this.posicion.esCompatible(posicion);
    }

    public void colocarUnidad(Unidad unidad){
        if(!unidad.sePuedeColocar(posicion)){
            throw new SeccionNoPermiteColocarUnidadesConPosicionIncompatible("");
        }
        unidadesColocadas.add(unidad);
    }

    public List<Unidad> getUnidadesColocadas(){
        return this.unidadesColocadas;
    }

//    public int calcularPuntaje(){
//        int total = 0;
//        for(Unidad unidad: unidadesColocadas){
//            total+= unidad.calcularPuntaje();
//        }
//        return total;
//    }

    public List<Unidad> removerCartasJugadas(){
        List<Unidad> descartadas = new ArrayList<>();
        while (!unidadesColocadas.isEmpty()) {
            descartadas.add(unidadesColocadas.remove(0));
        }
        return descartadas;
    }
}
