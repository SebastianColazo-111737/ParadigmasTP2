package edu.fiuba.algo3.pruebaDeConcepto;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private List<Unidad> unidadesJugadas = new ArrayList<>();

    public void colocarUnidad(Unidad unidad){
        this.unidadesJugadas.add(unidad);
    }

    public int calcularPuntaje(){
        int puntaje = 0;
        for (Unidad unidad: unidadesJugadas){
            puntaje += unidad.getPuntaje();
        }
        return puntaje;
    }
}
