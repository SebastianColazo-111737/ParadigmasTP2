package edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.posiciones;

public abstract class Posicion {

    public boolean esCompatible(Posicion posicionParaComparar){
        return this.getClass().equals(posicionParaComparar.getClass());
    }
}
