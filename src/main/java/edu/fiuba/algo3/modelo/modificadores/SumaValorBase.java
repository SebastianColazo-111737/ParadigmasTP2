package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.jugador.Seccion;

public class SumaValorBase implements Modificador{
    private int puntosExtras;

    public SumaValorBase(int puntosExtras){
        this.puntosExtras = puntosExtras;
    }

    @Override
    public void aplicarEfecto(Seccion seccion){
        seccion.puntosExtra(puntosExtras);
    }
}
