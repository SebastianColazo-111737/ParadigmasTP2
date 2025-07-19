package edu.fiuba.algo3.modelo.jugador.Atril;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Descarte {
    private List<Unidad> unidadesDescartadas;

    public Descarte(){
        this.unidadesDescartadas = new ArrayList<>();

    }

    public void descartarUnidad(Unidad unidad){
        this.unidadesDescartadas.add(unidad);
    }

    public void descartarUnidad(List<Unidad> unidades){
        this.unidadesDescartadas.addAll(unidades);
    }

    public List<Unidad> getUnidadesDescartadas(){
        return this.unidadesDescartadas;
    }

    public int getCantidadDeCartas(){return this.unidadesDescartadas.size();}
}
