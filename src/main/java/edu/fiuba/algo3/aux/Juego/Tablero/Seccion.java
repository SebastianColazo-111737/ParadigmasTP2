package edu.fiuba.algo3.aux.Juego.Tablero;

import edu.fiuba.algo3.aux.cartas.ICarta;
import edu.fiuba.algo3.aux.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private Posicion posicion;
    private List<Unidad> unidadesColocadas;

    public Seccion(Posicion posiccion){
        this.posicion = posiccion;
        this.unidadesColocadas = new ArrayList<>();
    }

    public Boolean puedeColocarse(Posicion posicion){
        return this.posicion.esCompatible(posicion);
    }

    public void colocarUnidad(Unidad unidad){
            unidadesColocadas.add(unidad);
    }

    public List<Unidad> getUnidadesColocadas(){
        return this.unidadesColocadas;
    }

    public int calcularPuntaje(){
        int total = 0;
        for(Unidad unidad: unidadesColocadas){
            total+= unidad.calcularPuntaje();
        }
        return total;
    }

    public List<ICarta> removerCartasJugadas(){
        List<ICarta> descartadas = new ArrayList<>();
        while (!unidadesColocadas.isEmpty()) {
            descartadas.add(unidadesColocadas.remove(0));
        }
        return descartadas;
    }
}
