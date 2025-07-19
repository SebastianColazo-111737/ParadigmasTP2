package edu.fiuba.algo3.modelo.carta.unidad.modificadores;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;

import java.util.List;

public class Legendaria extends UnidadModificada{

    public Legendaria(Unidad unidad) {
        super(unidad);
    }

    @Override
    public Puntaje getPuntaje(){
        Puntaje puntajeUnidad = super.getPuntaje();
        puntajeUnidad.resetearPuntaje();
        return puntajeUnidad;
    }

    @Override
    public void calcularPuntaje(List<Unidad> otrasUnidades, List<Efecto> efectos){
        // no se aplica los efectos
    }
}
