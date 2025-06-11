package edu.fiuba.algo3.clases.Posicion;

public class Asedio implements IPosicion{
    @Override
    public boolean esCompatible(IPosicion posicion) {
        return posicion instanceof Asedio;
    }
}
