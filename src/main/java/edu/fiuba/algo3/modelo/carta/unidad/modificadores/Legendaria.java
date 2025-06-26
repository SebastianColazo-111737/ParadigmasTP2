package edu.fiuba.algo3.modelo.carta.unidad.modificadores;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;

import java.util.List;

public class Legendaria extends UnidadModificada{

    public Legendaria(Unidad unidad) {
        super(unidad);
    }

    @Override
    public int getPuntajeActual(){
        unidad.resetearPuntaje();
        return unidad.getPuntajeActual();
    }

    @Override
    public void calcularPuntaje(List<Unidad> otrasUnidades, List<Efecto> efectos){

    }
}
