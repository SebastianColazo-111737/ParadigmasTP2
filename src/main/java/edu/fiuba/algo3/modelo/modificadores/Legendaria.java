package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.jugador.Seccion;

public class Legendaria implements Modificador {
    private Unidad unidadReferenciada;
    private int puntosLegendarios;

    public Legendaria(Unidad unidadReferenciada, int puntosLegendarios) {
        this.unidadReferenciada = unidadReferenciada;
        this.puntosLegendarios = puntosLegendarios;
    }

    @Override
    public void aplicarEfecto(Seccion seccion){
        unidadReferenciada.setPuntosBase(puntosLegendarios);
    }
}
