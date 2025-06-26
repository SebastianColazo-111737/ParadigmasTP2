package edu.fiuba.algo3.modelo.posicion;

public abstract class Posicion {

    public boolean esCompatible(Posicion posicionParaComparar){
        return this.equals(posicionParaComparar);
    }

    @Override
    public boolean equals(Object pos) {
        return this.getClass().equals(pos.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
